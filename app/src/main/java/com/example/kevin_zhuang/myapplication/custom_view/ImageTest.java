package com.example.kevin_zhuang.myapplication.custom_view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2017/3/14<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class ImageTest extends ImageView {
    private static final String TAG = ImageTest.class.getSimpleName();
    public ImageTest(Context context) {
        this(context,null);
    }

    public ImageTest(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ImageTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }


    @Override
    public void setImageDrawable(Drawable drawable) {
        Log.d(TAG, "setImageDrawable");
        if(drawable==null){
            Log.d(TAG, "drawable==null");
        }else{
            Log.d(TAG, "drawable!=null");

        }

        super.setImageDrawable(drawable);
    }



}
