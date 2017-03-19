package com.example.kevin_zhuang.myapplication.custom_view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/11/28<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class InputTextView extends TextView implements TextWatcher{


    private static final String TAG =InputTextView.class.getSimpleName() ;

    public InputTextView(Context context) {
        this(context,null);
    }

    public InputTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InputTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
//        super.onTextChanged(text, start, lengthBefore, lengthAfter);
//        if(text.length()>10){
//            this.setText(text.subSequence(0,text.length()-1));
//
//            Log.e(TAG,"超过10位");
//        }

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
