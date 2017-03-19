package com.example.kevin_zhuang.myapplication;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/11/25<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class FillOutTextView extends TextView implements TextWatcher{
    public FillOutTextView(Context context) {
        super(context);
    }

    public FillOutTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FillOutTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
