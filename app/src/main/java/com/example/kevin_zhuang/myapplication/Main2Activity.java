package com.example.kevin_zhuang.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.print.PrinterId;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.kevin_zhuang.myapplication.debug_package.ShowBgActivity;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.net.sip.SipErrorCode.TIME_OUT;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getSimpleName();
    private int result = -1;
    private int d = 0;


    private TextView mTextView;
    private TextView mTextView2;
    private TextView tvText3;

    private FileMake make;

    private Handler mHandler;
    private Runnable mRunnable;
    private boolean flag = true;
    private HttpUtils http = new HttpUtils();
    boolean isClick = false;
    String vurl = "https://od.lk/s/ODBfMzAzNjczXw/%E6%97%BA%E4%BB%94%E5%B0%8F%E9%A6%92%E5%A4%B42014%E3%80%8Aq%E5%AE%9D%E8%B4%9D%E7%AF%87%E3%80%8B30s%E9%9D%9E%E6%B4%BB%E5%8A%A8%E7%89%88-1.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                flag = true;
            }
        };
//        Log.e("MAIN","result="+getWe());
//        File f1 = new File("123");
//        try {
//            f1.createNewFile();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        setConfig(this,"as");
//        Log.e("MAin2","getConfig="+getConfig(this));
        mTextView = (TextView)findViewById(R.id.tvText);
        mTextView2 = (TextView)findViewById(R.id.tvText2);
        tvText3 = (TextView)findViewById(R.id.tvText3);
        make = new FileMake();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {


                    }
                }).start();


//                FileDownloader.getImpl().create(url)
//                              .setPath("/sdcard/ads")
//                        .setListener(new FileDownloadListener() {
//                            @Override
//                            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
//                                Log.d(TAG,"pending   soFarBytes="+soFarBytes+" totalBytes="+totalBytes);
//                            }
//
//                            @Override
//                            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
//                                Log.d(TAG,"progress   soFarBytes="+soFarBytes+" totalBytes="+totalBytes);
//
//                            }
//
//                            @Override
//                            protected void completed(BaseDownloadTask task) {
//                                Log.d(TAG,"completed");
//
//                            }
//
//                            @Override
//                            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
//                                Log.d(TAG,"paused "+" soFarBytes="+soFarBytes+" totalBytes="+totalBytes);
//
//                            }
//
//                            @Override
//                            protected void error(BaseDownloadTask task, Throwable e) {
//                                Log.d(TAG,"completed "+"e="+e.toString());
//
//                            }
//
//                            @Override
//                            protected void warn(BaseDownloadTask task) {
//                                Log.d(TAG,"warn ");
//
//                            }
//                        }).start();
//
//                http.download("https://od.lk/s/ODBfMzAzNjczXw/%E6%97%BA%E4%BB%94%E5%B0%82222F%E9%A6%92%E5%A4%B42014%E3%80%8Aq%E5%AE%9D%E8%B4%9D%E7%AF%87%E3%80%8B30s%E9%9D%9E%E6%B4%BB%E5%8A%A8%E7%89%88-1.mp4",
//                                                "/sdcard/xUtils/ads",
//                                                true, // 如果目标文件存在，接着未完成的部分继续下载。服务器不支持RANGE时将从新下载。
//                                                false, // 如果从请求返回信息中获取到文件名，下载完成后自动重命名。
//                                                new RequestCallBack<File>() {
//
//                                                        @Override
//                                                        public void onStart() {
//                                                            mTextView2.setText("conn...");
//                                                        }
//
//                                                        @Override
//                                                        public void onLoading(long total, long current, boolean isUploading) {
//                                                            mTextView2.setText(current + "/" + total);
//                                                        }
//
//                                                        @Override
//                                                        public void onSuccess(ResponseInfo<File> responseInfo) {
//                                                            mTextView2.setText("downloaded:" + responseInfo.result.getPath());
//                                                        }
//
//
//                                                        @Override
//                                                        public void onFailure(HttpException error, String msg) {
//                                                            mTextView2.setText(msg);
//                                                        }
//                                                    });
//
//                if(flag){
//                    flag = false;
//                    mHandler.postDelayed(mRunnable,5000L);
//                    Log.d(TAG,"mTextView onClick");
//                }
//
//                else{
//                    Log.d(TAG,"mTextView DELAY            onClick");
//
//                }
//                Log.d(TAG,"mTextView onClick");
//                make.init(Main2Activity.this);
            }
        });

        tvText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity.this, ShowBgActivity.class));
            }
        });




    }
    public static void setConfig(Context context, String config) {
        SharedPreferences sp = context.getSharedPreferences("ConfigParams", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        editor.putString("config", config);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }



    public static String getConfig(Context context) {
        SharedPreferences sp = context.getSharedPreferences("ConfigParams", Context.MODE_PRIVATE);
        String config = sp.getString("configas", "qwer");
        return config;
    }


    private int getWe(){
        try {
               result = 1/d;
        }catch (Exception e){

        }
        if(result == -1){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    d = 1;
                    Log.e("MAIN","getWe()");
                    getWe();
                }
            }, 3000L);
        }
        return result;
    }
}
