package com.example.kevin_zhuang.myapplication;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/12/9<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class FileMake {

    private static final String TAG = FileMake.class.getSimpleName();
    private static final String packageName = "com.want.vmc100";
    private static final String AssetsFileName = "config.ini";


    private static final String
            FILE_PATH =
            File.separator +
            "sdcard" +
            File.separator +
            "Android" +
            File.separator +
            "data" +
            File.separator +
            packageName +
            File.separator +
            "set";

    private static final String FILE_NAME = FILE_PATH + File.separator + "config.ini";

    public FileMake(){

    }

    /**
     * 单例模式
     * @return 单例
     */
//    public static FileMake getInstance() {
//        return FileMakeHolder.fileMake;
//    }

    /**
     * 构造方法私有化
     */
//    private FileMake() {
//
//    }


    /**
     * 私有静态内部类
     */
//    private static class FileMakeHolder{
//        private static FileMake fileMake = new FileMake();
//    }

    /**
     * 初始化 没有判断外部存储
     * @param context 上下文
     */
    public void init(Context context){
        Log.d(TAG,"init");
        try {
            File file = new File(FILE_NAME);
            if(file.exists()){
                Log.d(TAG,"文件已经存在 "+FILE_NAME);
                return;
            }
            createDir();
            InputStream is = context.getAssets().open(AssetsFileName);
            copyFile(is, file);

        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "IOException="+e.toString());
        }

    }

    /**
     * 创建文件夹
     */
    private void createDir() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            //mkdir只能创建一级目录，mkdir可以创建多级目录
            boolean isMakeSuccess = file.mkdirs();
            if(!isMakeSuccess){
                Log.e(TAG, "dir is make fail");
                return;
            }
            Log.d(TAG, "dir is make" + file.getAbsolutePath());
        }
    }

    private void copyFile(InputStream is, File file) {
        try {
            if(null==file||null==is){
                Log.e(TAG, "File or InputStream is null");
                return;
            }
            int byteRead;
            if (!file.exists()) {
                try {
                    boolean isCreateSuccess = file.createNewFile();
                    if(!isCreateSuccess) {
                        Log.e(TAG, "file is create fail");
                        return;
                    }
                    FileOutputStream fs = new FileOutputStream(file.getAbsolutePath());
                    byte[] buffer = new byte[1024];
                    while ((byteRead = is.read(buffer)) != -1) {
                        fs.write(buffer, 0, byteRead);
                    }
                    is.close();
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "创建文件");
            }

        } catch (Exception e) {
            Log.e(TAG, "复制文件操作出错");
            e.printStackTrace();


        }

    }




}
