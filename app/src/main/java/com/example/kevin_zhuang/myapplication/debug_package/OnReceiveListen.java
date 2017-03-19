package com.example.kevin_zhuang.myapplication.debug_package;

import android.support.annotation.Nullable;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2017/3/6<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public interface OnReceiveListen {
    void onReceiveData(byte[] data, int len, @Nullable String remoteIp);
}
