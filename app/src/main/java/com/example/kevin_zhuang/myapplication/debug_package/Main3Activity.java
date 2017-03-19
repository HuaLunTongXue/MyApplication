package com.example.kevin_zhuang.myapplication.debug_package;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kevin_zhuang.myapplication.GlideRoundTransform;
import com.example.kevin_zhuang.myapplication.R;
import com.example.kevin_zhuang.myapplication.custom_view.CornerView;
import com.example.kevin_zhuang.myapplication.custom_view.ImageTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.net.sip.SipErrorCode.TIME_OUT;

public class Main3Activity extends AppCompatActivity {


    private static final String TAG = Main3Activity.class.getSimpleName();

    private EditText mEditText;
    private TextView tvShowInfoIntent;
    private Button btnStartApp;
    private SingleUdp singleUdp;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e(TAG,"接收广播");
        }
    };

    private DownloadManager downloadManager;
    private long mTaskId;
    private String downUrl = "http://wantvmc.gz.bcebos.com/%E6%97%BA%E4%BB%94%E7%89%9B%E5%A5%B6%E5%B9%BF%E5%91%8A1.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2016-09-08T09%3A25%3A27Z%2F-1%2Fhost%2F8a5fd70a7b5d10f7ff8f4e536cb9824ed70808616f1c885f9c80b7126863993a";
    private String downUrl2 = "http://wantvmc.gz.bcebos.com/%E6%97%BA%E4%BB%94%E7%89%9B%E5%A5%B6%E5%B9%BF%E5%91%8A1.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2016-09-08T09%3A25%3A27Z%2F-1%2Fhost%2F8a5fd70a7b5d10f7ff8f4e536cb9824ed70808616f1c885f9c80b7126863993a";
    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override

        public void onReceive(Context context, Intent intent) {

            checkDownloadStatus();//检查下载状态

        }

    };

    private CornerView image;
    private ImageTest imageT;
    private CheckBox mCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tvShowInfoIntent = (TextView)findViewById(R.id.tvShowInfoIntent);
//        tvShowInfoIntent.setText(getIntent().getExtras().getString("test"));
        btnStartApp = (Button)findViewById(R.id.btnStartApp);
//        image = (CornerView)findViewById(R.id.imageC);
        imageT= (ImageTest)findViewById(R.id.imageT);
        singleUdp = SingleUdp.getUdpInstance();
        singleUdp.setUdpIp("10.128.230.130");
        singleUdp.setUdpRemotePort(9998);
        singleUdp.setUdpLocalPort(9997);
        singleUdp.start();
        singleUdp.receiveUdp();
        singleUdp.setOnReceiveListen(new OnReceiveListen() {
            @Override
            public void onReceiveData(byte[] data, int len, @Nullable String remoteIp) {
                Log.e(TAG,"" +bytes2HexString(data,len));
                if(bytes2HexString(data,len).equals("313233")){
                    Intent intent = new Intent("com.want.vmc.VMC_TO_BLL_DOOR_STATE");
                    intent.putExtra("doorState",true);
                    sendBroadcast(intent);
                    MLog.i("doorState="+"true");

                }else if(bytes2HexString(data,len).equals("343536")){
                    Intent intent = new Intent("com.want.vmc.VMC_TO_BLL_DOOR_STATE");
                    intent.putExtra("doorState",false);
                    sendBroadcast(intent);
                    MLog.i("doorState="+"false");

                }


            }
        });
        singleUdp.send("123456".getBytes());

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }else{

                }
            }
        });
//        btnStartApp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(getPackageManager().getLaunchIntentForPackage("com.example.kevin_zhuang.myapplication2"));
//
//            }
//        });
////
//        registerReceiver(mBroadcastReceiver,new IntentFilter("com.test"));

    }

    @Override
    protected void onDestroy() {
//        unregisterReceiver(mBroadcastReceiver);
        super.onDestroy();
    }

    public void testOnclick(View view) {

//        image.setBackground(R.drawable.bg720x1208);

//        Glide.with(this)
//             .load("https://www.baidu.com/img/bd_logo1.png")
//             .error(R.drawable.bg720x1208)
//             .dontAnimate()
//             .transform(new GlideRoundTransform(this, 10))
//             .into(imageT);

        Glide.with(this)
             .load("")
             .error(R.drawable.watergod_home_guide_img_poster)
             .transform(new GlideRoundTransform(this, 10))
             .into(imageT);


//        image.setBackgroundResource(R.drawable.bg720x1208);

//        AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
//        mEditText = new EditText(Main3Activity.this);
//        builder.setView(mEditText);
//        mEditText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
//
//        builder.setTitle("密码？");
//        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if(mEditText.getText().toString().equals("123456")){
//                    Toast.makeText(Main3Activity.this,"True",Toast.LENGTH_SHORT).show();
//
//                }
//                Toast.makeText(Main3Activity.this,"mEditText="+mEditText.getText().toString(),Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//
//            }
//        })
//               .setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                   @Override
//                   public void onClick(DialogInterface dialog, int which) {
//                       dialog.dismiss();
//                   }
//               })
//               .show();



    }

    /**
     * byte数组转16进制字符串
     */
    public static String bytes2HexString(byte[] b, int byteLength) {
        String ret = "";
        for (int i = 0; i < byteLength; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }


    private void downloadFile(String versionUrl, String versionName) {
        MLog.i("记录开始下载时间");
        //创建下载任务
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(versionUrl));
        request.setAllowedOverRoaming(true);//漫游网络是否可以下载

        //设置文件类型，可以在下载结束后自动打开该文件
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String mimeString =mimeTypeMap.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(versionUrl));
        request.setMimeType(mimeString);

        //在通知栏中显示，默认就是显示的
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setVisibleInDownloadsUi(false);
//        Environment.getExternalStorageDirectory().getPath()
        //sdcard的目录下的download文件夹，必须设置
        request.setDestinationInExternalPublicDir("/Android/data/", versionName);
//        request.setDestinationInExternalFilesDir(this,versionUrl,versionName);//也可以自己制定下载路径
        //将下载请求加入下载队列
        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        //加入下载队列后会给该任务返回一个long型的id，
        //通过该id可以取消任务，重启任务等等，看上面源码中框起来的方法
        mTaskId = downloadManager.enqueue(request);
        //注册广播接收者，监听下载状态

        registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

    }


    private void checkDownloadStatus() {

        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(mTaskId);//筛选下载任务，传入任务ID，可变参数
        Cursor c = downloadManager.query(query);
        if (c.moveToFirst()) {
            int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
            switch (status) {
                case DownloadManager.STATUS_PAUSED:
                    MLog.i(">>>下载暂停");
                case DownloadManager.STATUS_PENDING:
                    MLog.i(">>>下载延迟");
                case DownloadManager.STATUS_RUNNING:
                    MLog.i(">>>正在下载");
                    break;
                case DownloadManager.STATUS_SUCCESSFUL:
                    MLog.i(">>>下载完成");
//                    //下载完成安装APK
//                    //downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + versionName;
//                    installAPK(new File(downloadPath));
                    break;
                case DownloadManager.STATUS_FAILED:
                    MLog.i(">>>下载失败");
                    break;
            }
        }
    }

    public void btnClickDownVideo(View view) {

        File file = new File(Environment.getExternalStorageDirectory()+"/Android/data/","testDownFile");
        if(file.exists()){
            MLog.i("文件已经存在");
            return;
        }

        downloadFile(downUrl,"testDownFile");

//        urlDownLaod();

    }


    private void urlDownLaod(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//            File cacheDir = getCacheDir();
                    MLog.i("记录开始下载时间");
                    URL url = new URL(downUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(3000);
                    conn.setReadTimeout(3000);
                    conn.connect();
                    RandomAccessFile fos;
                    File cacheFile;
                    cacheFile = new File("/sdcard/Android/","testVideo");
                    fos = new RandomAccessFile(cacheFile, "rw");
                    InputStream ins = conn.getInputStream();
                    byte[] byts = new byte[1024 * 10];
                    int count;
                    while ((count = ins.read(byts)) >= 0) {
                        fos.write(byts, 0, count);
                    }
                    MLog.i("下载完成");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }


    public static class MLog{
        private static void i(String data){
            Log.i(TAG,data);
        }
    }



}
