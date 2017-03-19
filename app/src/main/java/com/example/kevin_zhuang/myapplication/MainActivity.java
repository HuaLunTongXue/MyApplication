package com.example.kevin_zhuang.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevin_zhuang.myapplication.annotation.FruitColor;
import com.example.kevin_zhuang.myapplication.annotation.FruitName;
import com.example.kevin_zhuang.myapplication.annotation.FruitProvider;
import com.example.kevin_zhuang.myapplication.annotation.FunAnnotation;
import com.example.kevin_zhuang.myapplication.custom_view.GifView;
import com.example.kevin_zhuang.myapplication.custom_view.InputTextView;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String
            FILE_PATH =
            File.separator +
            "sdcard" +
            File.separator +
            "Android" +
            File.separator +
            "data" +
            File.separator +
            "com.want.vmc100" +
            File.separator +
            "set";
    private static final String FILE_NAME = FILE_PATH + File.separator + "config.ini";

    //    private InterfaceTest mInterfaceTest = new InterfaceTest();
//
//    @FruitName(value = "FuShi Apple")
//    private String mFruitName;
//    private EditText etInput;
//
//    private List<String> mData = new ArrayList<>();
//    private ListView listView;
//    private ZAdapter mZAdapter;
//    private int mWidth;
//    private int mHeight;
//    private ViewTreeObserver vto;
//    private InputTextView mInputTextView;
//
//    private Button btn1;
//    private Button btn2;
//    private Button btn3;
//    private Button btn4;
//    private Button btn5;
//    private Button btn6;
//    private Button btn7;
//    private Button btn8;
//    private Button btn9;
//    private Button btn0;
//    private Button btnX;
//    private Button btnBack;
//    private String mString = "";
    private BroadcastReceiver mWifiChangedReceiver;
    private boolean isWhile = true;
    private GifView gifView;
    private Handler handler = new Handler();
    private Runnable mRunnable;

//    private Timer mTimer = new Timer();
//    private TimerTask mTimerTask;

    private int i = 0;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btn_test_layout);
        Button btnTest = (Button) findViewById(R.id.btnTest);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        final EditText etInput = (EditText)findViewById(R.id.etInput);

        List list =null;
        if(list==null){

        }

//        mTimerTask = new TimerTask() {
//            @Override
//            public void run() {
//                Log.e(TAG,"i="+i++);
//            }
//        };
//
//        mTimer.schedule(mTimerTask,1000L,1000L);

        //timer 10：21：30 1.50M
        //timer 10：25：30 1.60M


        mRunnable = new Runnable() {
            @Override
            public void run() {
                Log.e(TAG,"i="+i++);
                if(i==30){
                    i=0;
                    handler.removeCallbacks(mRunnable);
                }
                handler.postDelayed(mRunnable,1000L);
            }
        };

        handler.postDelayed(mRunnable,1000L);

        //handler 10：08：40  1.50M
        //handler 10：12：50  1.60M


        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(imm.isActive()){
                    imm.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
                }else{
                    imm.showSoftInput(etInput,InputMethodManager.SHOW_FORCED);
//                    ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(WidgetSearchActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS); (WidgetSearchActivity是当前的Activity)
                }
//                FileMake fileMake = FileMake.getInstance();
//                fileMake.init(MainActivity.this);

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {

//                        toastInfo("你好");


                //建立set文件夹和config.ini文件
//                createDir();
//                try {
//                    InputStream is = getAssets().open("config.ini");
//
//                    copyFile(is, FILE_NAME);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Log.d(TAG, "IOException");
//                }


//                    }
//                });
            }
        });


//        mInputTextView = (InputTextView) findViewById(R.id.inputTextView);
//
//        btn1 = (Button) findViewById(R.id.btn1);
//        btn2 = (Button) findViewById(R.id.btn2);
//        btn3 = (Button) findViewById(R.id.btn3);
//        btn4 = (Button) findViewById(R.id.btn4);
//        btn5 = (Button) findViewById(R.id.btn5);
//        btn6 = (Button) findViewById(R.id.btn6);
//        btn7 = (Button) findViewById(R.id.btn7);
//        btn8 = (Button) findViewById(R.id.btn8);
//        btn9 = (Button) findViewById(R.id.btn9);
//        btn0 = (Button) findViewById(R.id.btn0);
//        btnX = (Button) findViewById(R.id.btnX);
//        btnBack = (Button) findViewById(R.id.btnBack);
//
//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
//        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
//        btn5.setOnClickListener(this);
//        btn6.setOnClickListener(this);
//        btn7.setOnClickListener(this);
//        btn8.setOnClickListener(this);
//        btn9.setOnClickListener(this);
//        btn0.setOnClickListener(this);
//        btnX.setOnClickListener(this);
//        btnBack.setOnClickListener(this);

        /*
        listView = (ListView) findViewById(R.id.listView);

//        mData.add("1");
//        mZAdapter = new ZAdapter(this,mData);
//        listView.setAdapter(mZAdapter);
        vto = listView.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                listView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mWidth = listView.getMeasuredWidth();
                mHeight = listView.getMeasuredHeight();
                Log.d(TAG,"mWidth="+mWidth +" mHeight="+mHeight);

            }
        });

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        Log.d(TAG,"width="+params.width +" height="+params.height);

        params.width = 100;
        params.height = 500;

        listView.setLayoutParams(params);


        mData.add("1");
        mData.add("2");
        mData.add("3");
        mData.add("4");
        mData.add("5");
        mZAdapter = new ZAdapter(this,mData);
        listView.setAdapter(mZAdapter);


//        Button btnTest = (Button) findViewById(R.id.btnTest);
//        final EditText etInput = (EditText)findViewById(R.id.etInput);
//        final TextView tvShowInfo = (TextView)findViewById(R.id.tvShowInfo);
//
//        btnTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s = etInput.getText().toString();
//                tvShowInfo.setText("sub="+s.substring(0,getEnglishAndChineselength(s)));
//            }
//        });
//        btnTest.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                String s = "圆圆月饼有限公司测试公司名称超过18位时在APP如何显示的需求";
//                tvShowInfo.setText("sub="+s.substring(0,getEnglishAndChineselength(s)));
//                return true;
//            }
//        });


        */


        /*
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
//                    mInterfaceTest.one(Integer.parseInt(etInput.getText().toString()));
//                    tvShowInfo.setText(etInput.getText().toString()+" is OK!");
//                } catch (Exception e) {
//                    tvShowInfo.setText(e.toString());
//                }
                getInfo("com.example.kevin_zhuang.myapplication.Apple");
                try {


                    String name  = parseMethod(MainActivity.class);
                    Log.d(TAG,"name="+name);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
//                tvShowInfo.setText("fruitName="+mFruitName);

            }
        });
    */


    }

    private void createDir() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            //mkdir只能创建一级目录，mkdir可以创建多级目录
            file.mkdirs();
            Log.d(TAG, "dir is make" + file.getAbsolutePath());
        }
    }


    /**
     * 复制单个文件
     *
     * @param newPath String 复制后路径 如：f:/fqf.txt
     *
     * @return boolean
     */
    public void copyFile(InputStream is, String newPath) {
        try {
//            int bytesum = 0;
            int byteread;
            File file = new File(newPath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d(TAG, "创建文件");
            }
            FileOutputStream fs = new FileOutputStream(newPath);
            byte[] buffer = new byte[1024];
            while ((byteread = is.read(buffer)) != -1) {
//                bytesum += byteread; //字节数 文件大小
//                Log.d(TAG, "bytesum=" + bytesum);
                fs.write(buffer, 0, byteread);
            }
            is.close();
        } catch (Exception e) {
            Log.d(TAG, "复制单个文件操作出错");
            e.printStackTrace();

        }

    }

    /**
     * 复制整个文件夹内容
     *
     * @param oldPath String 原文件路径 如：c:/fqf
     * @param newPath String 复制后路径 如：f:/fqf/ff
     *
     * @return boolean
     */
    public void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                                                                   (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {//如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }

    }


    public String parseMethod(Class<?> clazz) throws
                                              NoSuchMethodException,
                                              IllegalAccessException,
                                              InvocationTargetException,
                                              InstantiationException {
        Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        for (Method method : clazz.getDeclaredMethods()) {
            FunAnnotation mFunAnnotation = method.getAnnotation(FunAnnotation.class);
            if (mFunAnnotation != null) {
                String name = mFunAnnotation.name();
                return (String) method.invoke(obj, name);
            }
        }
        return "";
    }


    @FunAnnotation(name = "kevin")
    public String testFunAnnotation(String name) {
        if (null == name) {
            name = "";
        }
        return name + " say HelloWord!";
    }

    public void getInfo(String className) {
        try {
            Class<?> cls = Class.forName(className);
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(FruitName.class)) {
                    FruitName fruitName = field.getAnnotation(FruitName.class);
                    Log.d(TAG, "fruitName = " + fruitName.value());
                }
                if (field.isAnnotationPresent(FruitColor.class)) {
                    FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                    Log.d(TAG, "fruitColor = " + fruitColor.fruitColor());
                }

                if (field.isAnnotationPresent(FruitProvider.class)) {
                    FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                    Log.d(TAG, "fruitProvide_id=" + fruitProvider.id()
                               + " fruitProvide_user=" + fruitProvider.user()
                               + " fruitProvide_address=" + fruitProvider.address());
                }

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static int getEnglishAndChineselength(String s) {
        int length = 0;
        int chineseLength = 0;
        int englishLength = 0;
        for (int l = 0; l < s.length(); l++) {
            // 判断是否是中文的正则表达式编码:  [\u4e00-\u9fa5]+   (后面的 "+" 号不能省略)
            boolean matches = Pattern.matches("[\\u4e00-\\u9fa5]+", s.charAt(l) + "");
            while (matches) {
                chineseLength++;
                matches = false;
            }
        }
        englishLength = (s.length() - chineseLength) * 2;
        length = englishLength + chineseLength;
        return length;
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn1:
//                mString +="1";
//                break;
//            case R.id.btn2:
//                mString +="2";
//                break;
//            case R.id.btn3:
//                mString +="3";
//                break;
//            case R.id.btn4:
//                mString +="4";
//                break;
//            case R.id.btn5:
//                mString +="5";
//                break;
//            case R.id.btn6:
//                mString +="6";
//                break;
//            case R.id.btn7:
//                mString +="7";
//                break;
//            case R.id.btn8:
//                mString +="8";
//                break;
//            case R.id.btn9:
//                mString +="9";
//                break;
//            case R.id.btn0:
//                mString +="0";
//                break;
//            case R.id.btnX:
//                mString = "";
//                break;
//            case R.id.btnBack:
//                mString = mString.substring(0,mString.length()-1);
//                break;
//        }
//        mInputTextView.setText(mString);
//
//    }


    private Toast mToast;
    private TextView tvText = null;

    public void toastInfo(String data) {
        View view;

        if (mToast == null) {
            mToast = Toast.makeText(this, data, Toast.LENGTH_SHORT);

            view = View.inflate(this, R.layout.toast_layout, null);
            mToast.setView(view);
            tvText = (TextView) view.findViewById(R.id.tvText);
//            mToast = Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT);
            tvText.setText(data);
        } else {
            tvText.setText(data);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }


    public void dialogInfo() {

    }


    private void brodcastWifi() {
        mWifiChangedReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager
                        connectivityManager =
                        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager == null) {
                    Log.e(TAG, "connectivityManager is null");
                    return;
                }

                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                NetworkInfo
                        networkInfo2 =
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


                //1、连接到wifi 没有连接到手机 如果没有网络 弹窗
                //2、没有连接wifi 连接到手机 如果没有网络 弹窗
                //3、没有连接wifi 没有连接手机 必弹窗
                if ((networkInfo == null || !networkInfo.isConnected()) &&
                    (networkInfo2 == null || !networkInfo2.isConnected())) {
                    Log.e(TAG, "2个网络都没有连接 弹窗提示");
                } else {

                    if (networkInfo != null && networkInfo.isConnected()) {

                        if (isNetworkOnline()) {
                            Log.e(TAG, " WIFI 可用");
                        } else {
                            Log.e(TAG, " WIFI 不可用");
                        }

                    }

                    if (networkInfo2 != null && networkInfo2.isConnected()) {
                        if (isNetworkOnline()) {
                            Log.e(TAG, " 手机网络 可用");
                        } else {
                            Log.e(TAG, " 手机网络 不可用");
                        }
                    }

                }

            }
        };
        //注册广播
        registerReceiver(mWifiChangedReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }


    public boolean isNetworkOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("ping -c 1 www.baidu.com");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(mWifiChangedReceiver);
    }


}
