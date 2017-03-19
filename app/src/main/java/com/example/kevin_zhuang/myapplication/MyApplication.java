package com.example.kevin_zhuang.myapplication;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;


/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2017/1/7<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        x.Ext.init(this);
        FileDownloader.init(getApplicationContext());
    }
}
