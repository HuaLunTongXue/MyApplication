package com.example.kevin_zhuang.myapplication;

import android.util.Log;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/12/29<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class VarClass {

    private static final String TAG = VarClass.class.getSimpleName();

    public boolean isBack = true;

    public VarClass(){
        fun();
    }

    private void fun(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "isBack=" + isBack);
            }
        }).start();
    }


}
