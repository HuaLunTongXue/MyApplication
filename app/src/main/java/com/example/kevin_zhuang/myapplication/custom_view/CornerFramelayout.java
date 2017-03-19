package com.example.kevin_zhuang.myapplication.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

import com.example.kevin_zhuang.myapplication.R;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2017/1/17<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class CornerFramelayout extends FrameLayout {

    private int mWidth;
    private int mHeight;
    private int CCornerWhich;
    private int CCornerRadius;
    private Bitmap CBackground;

    public CornerFramelayout(Context context) {
        this(context, null);
    }

    public CornerFramelayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CornerFramelayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray
                ta =
                context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView, defStyle, 0);

        int n = ta.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = ta.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTextView_CBackground:
                    CBackground = BitmapFactory.decodeResource(getResources(), ta.getResourceId(attr, 0));

                    break;
                case R.styleable.CustomTextView_CCornerRadius:
                    CCornerRadius =
                            ta.getDimensionPixelSize(attr,
                                                     (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                                                                     10f,
                                                                                     getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomTextView_CCornerWhich:
                    CCornerWhich = ta.getInt(attr, 0);
                    break;
            }

        }
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasureWidth(widthMeasureSpec);
        mHeight = getMeasureHeight(heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);

    }


    private int getMeasureWidth(int measureSpec) {
        int measureSize = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            measureSize = specSize;
        } else {
            int desireByImg = getPaddingLeft() + getPaddingRight() + CBackground.getWidth();
            if (specMode == MeasureSpec.AT_MOST)// wrap_content
            {
                measureSize = Math.min(desireByImg, specSize);
            }
        }
        return measureSize;
    }


    private int getMeasureHeight(int measureSpec) {
        int measureSize = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            measureSize = specSize;
        } else {
            int desireByImg = getPaddingTop() + getPaddingBottom() + CBackground.getHeight();
            if (specMode == MeasureSpec.AT_MOST)// wrap_content
            {
                measureSize = Math.min(desireByImg, specSize);
            }
        }
        return measureSize;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(createBitmapByCorner(CBackground, CCornerWhich, CCornerRadius), 0, 0, null);
        super.onDraw(canvas);

    }


    private Bitmap createBitmapByCorner(Bitmap bitmap, int cornerWhich, int radius) {
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
        int width = mWidth;
        int height = mHeight;
        Bitmap target = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);

        Paint paint = new Paint();
        paint.setAntiAlias(true);

//        if (cornerWhich == ALL) {
//            Rect rect = new Rect(0, 0, width, height);
//            canvas.drawRect(rect, paint);
//        } else if (cornerWhich == TOP_LEFT) {
//            Rect rect = new Rect(radius, 0, width, height);
//            canvas.drawRect(rect, paint);
//            Rect rect2 = new Rect(0, height - radius, width, height);
//            canvas.drawRect(rect2, paint);
//            RectF rectF = new RectF(0, 0, 2 * radius, height);
//            canvas.drawRoundRect(rectF, radius, radius, paint);
//
//        } else if (cornerWhich == TOP_RIGHT) {
//            Rect rect = new Rect(0, 0, width - radius, height);
//            canvas.drawRect(rect, paint);
//            Rect rect2 = new Rect(0, radius, width, height);
//            canvas.drawRect(rect2, paint);
//            RectF rectF = new RectF(width - 2 * radius, 0, width, height);
//            canvas.drawRoundRect(rectF, radius, radius, paint);
//
//        } else if (cornerWhich == BOTTOM_LEFT) {
//            Rect rect = new Rect(radius, 0, width, height);
//            canvas.drawRect(rect, paint);
//            Rect rect2 = new Rect(0, 0, width , radius);
//            canvas.drawRect(rect2, paint);
//            RectF rectF = new RectF(0, 0, 2*radius, height);
//            canvas.drawRoundRect(rectF, radius, radius, paint);
//
//        } else if (cornerWhich == BOTTOM_RIGHT) {
//
//            Rect rect = new Rect(0, 0, width, height - radius);
//            canvas.drawRect(rect, paint);
//            Rect rect2 = new Rect(0, 0, radius, height);
//            canvas.drawRect(rect2, paint);
//            RectF rectF = new RectF(0, height - 2 * radius, width, height);
//            canvas.drawRoundRect(rectF, radius, radius, paint);
//        }

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        Matrix mMatrix = new Matrix();
        mMatrix.postScale(mWidth,mHeight);
        canvas.drawBitmap(bitmap,mMatrix,paint);
        return target;
    }



}
