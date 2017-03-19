package com.example;


import com.example.test_class.User;
import com.example.test_class.Value;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class MyClass {

    private static Value value;

    public static void main(String[] args) {
//        System.out.println("Hello");
        String s1 = "一二三四五六78九十APPST 一二三四";
        String s2 = "圆圆月饼有123ml限公ll司（测试公" +
                    "司名称超过位时在如何显示的需求）";
        String s3 = "123456789012345678901234 5";
        String s4 = "一二三四五六七八九十一二三四五六七八九十";
        String s5 = "1234567890一二12345678901234";
        String s6 = "qwert";

//        System.out.println("sub="+s.substring(0,getEnglishAndChineselength(s,12)));
//        System.out.println(""+getEnglishAndChineselength(s,12));
//
//        System.out.println("sub="+ss.substring(0,getEnglishAndChineselength(ss,12)));
//
//        System.out.println(""+getEnglishAndChineselength(ss,12));





        String s6s[] = s6.split("");
        for (String ms6 :
                s6s) {
            System.out.println("ms6="+ms6);
        }

        System.out.println("sub=" + frontString(s1));
        System.out.println();
        System.out.println("sub=" + frontString(s2));
        System.out.println();
        System.out.println("sub=" + frontString(s3));
        System.out.println();
        System.out.println("sub=" + frontString(s4));
        System.out.println();
        System.out.println("sub=" + frontString(s5));
        System.out.println();
        System.out.println("encode=" + getEncoding(s6));

        System.out.println("StringFormat=" + String.format("%.0f", 2.333));

        System.out.println("s2=" + s2 + "s2L=" + s2.getBytes().length + " getEncoding=" + getEncoding(s2));

        try {
            byte[] s2Bytes = s2.getBytes();
            String ss2 = new String(s2Bytes, "UTF-8");
            System.out.println("ss2=" +
                               ss2 +
                               "ss2L=" +
                               ss2.getBytes().length +
                               " getEncoding=" +
                               getEncoding(ss2));

            int sub1 = 4;
            byte[] ss2Bytes = ss2.getBytes();
            byte[] s2ByteCopy = new byte[sub1];
            System.arraycopy(ss2Bytes, 0, s2ByteCopy, 0, sub1);
            String nString = new String(s2ByteCopy);


            System.out.println("nString=" + nString);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int sub1 = 4;
        byte[] s2Bytes = s2.getBytes();
        byte[] s2ByteCopy = new byte[sub1];
        System.arraycopy(s2Bytes, 0, s2ByteCopy, 0, sub1);
        String nString = new String(s2ByteCopy);


        System.out.println("nString=" + nString);


//        float aa = Float.parseFloat("5.34");
        float aa = (float) 5.14;
        double bb = 5.24;

        String saa = String.valueOf(aa);
        String sbb  = String.valueOf(bb);

        System.out.println("daxiao="+(aa>bb)+" aa="+aa+ " ss="+saa.equals(sbb));

        value = Value.getInstance();
        value.inc();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Value value = Value.getInstance();
                value.inc();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Value value = Value.getInstance();
                value.inc();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Value value = Value.getInstance();
                value.inc();
            }
        }).start();

        try {
            Thread.sleep(10);
            System.out.println("Value.c="+value.c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("=========================");
        List<String> list = new ArrayList<>();
        list.add("Aili");
        list.add("weixin");
        list.add("xianjin");
        list.add("wangbi");

        System.out.println("is="+list.contains(""));

        User us1 = new User();
        us1.setName("123");
        us1.setPw("456");

        User u2 ;
        u2 = us1;
        u2.setName("7777");

        System.out.println("u1="+us1.getName());
        String path = "/Users/kevin_zhuang";

        renameFile(path,"123","456");

        boolean a = false;
        boolean b = true;
        int c = 1;
        int d = 2;
        int e = 3;

        int re = a?c:   b?d:e;

        System.out.println("re="+re);


        String dString = "1.23";
        System.out.println("dString="+Double.valueOf(dString).intValue());


        String sNull = null;
        System.out.println("sNull="+sNull);

        File file = new File("/Users/kevin_zhuang","adss");
        if(file.exists()){
            System.out.println("file="+file.getAbsolutePath());

        }else{
            System.out.println("file不存在");

        }




    }

    public static void renameFile(String path, String oldname, String newname){
        if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile=new File(path + "/" + oldname);
            File newfile=new File(path+"/"+newname);
            if(!oldfile.exists()){
                return;//重命名文件不存在
            }
            if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                System.out.println(newname+"已经存在！");
            else{
                oldfile.renameTo(newfile);
            }
        }else{
            System.out.println("新文件名和旧文件名相同...");
        }
    }





    public static String frontString(String data) {
        int[] sb = getEnglishAndChineselength(data, 12);
        int l = sb[0];
        int spaces = sb[1];
        System.out.println("l=" + l + " spaces=" + spaces);
        if (spaces <= 12) {
            return data;
        } else if (spaces < 24) {
            return data.substring(0, l);
        } else {
            return data.substring(0, l);
        }
    }

    /**
     * 返回要截取的长度
     *
     * @param s
     *
     * @return
     */

    // 一二三四五六78九十APPST一二三四
    public static int[] getEnglishAndChineselength(String s, int subLength) {
        int[] returnInts = {0, 0};
        int length;
        int chineseLength = 0;
        int not_chineseLength = 0;
//        String returnString;
        int ml = 0;
        boolean matches;
        for (int l = 0; l < s.length(); l++) {
            // 判断是否是中文的正则表达式编码:  [\u4e00-\u9fa5]+   (后面的 "+" 号不能省略)
            matches = Pattern.matches("[\\u4e00-\\u9fa5]+", s.charAt(l) + "");
            if (matches) {
                chineseLength++;
            } else {
                not_chineseLength++;
            }

            if ((chineseLength + not_chineseLength / 2) == subLength) {
                System.out.println("ee 1=" + not_chineseLength + " cc=" + chineseLength);
                ml = l;
            }

//            if ((2*chineseLength + not_chineseLength) == 2*subLength) {
//                System.out.println("ee 1="+not_chineseLength+" cc="+chineseLength);
//                ml = l+1;
//            }else if ((2*chineseLength + not_chineseLength -1) == 2*subLength){
//                System.out.println("ee  2="+not_chineseLength+" cc="+chineseLength);
//                ml = l;
//            }


        }

//        System.out.println("e="+englishLength+" c="+chineseLength);
        returnInts[0] = ml;
        not_chineseLength = (s.length() - chineseLength) / 2;
//        System.out.println("eeeeeee="+englishLength+" c="+chineseLength);
        length = not_chineseLength + chineseLength;
        returnInts[1] = length;
        return returnInts;
    }
/*

    public static int zhuang(String s){
        int length ;
        int chineseLength = 0;
        int englishLength = 0;
        boolean matches;
        for (int l = 0; l < s.length(); l++) {
            // 判断是否是中文的正则表达式编码:  [\u4e00-\u9fa5]+   (后面的 "+" 号不能省略)
            matches = Pattern.matches("[\\u4e00-\\u9fa5]+", s.charAt(l) + "");
            if(!matches){
                matches = false;
                String s2 = s.substring()+" "+s.substring();

            }

        }
        englishLength = (s.length() - chineseLength) / 2;
        length = englishLength + chineseLength;


        return 0;
    }
*/


//    public String[] sadjasgd(String ss,int ll){
//
//    }

    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }


}

/*
mWifiChangedReceiver=new BroadcastReceiver(){
@Override
public void onReceive(Context context,Intent intent){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager==null){
        Log.e(TAG,"connectivityManager is null");
        }
        NetworkInfo networkInfo=connectivityManager!=null?connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI):null;
        if(networkInfo!=null&&networkInfo.isConnected()){
        btnSettingWifi.setVisibility(View.GONE);
        String stringssid=getSSid();

        //第一次连接到robotAP验证
        Log.e(TAG,"robotAPSSID="+robotAPSSID+" stringssid="+stringssid+" firstUdpRunOnce="+firstUdpRunOnce);
        if(robotAPSSID.equals(stringssid)){

        if(firstUdpRunOnce==0){
        firstUdpRunOnce=1;
        flagConnSucessRobotAP=1;
        Log.e(TAG,"连接成功");
        SmartLinkActivity.this.runOnUiThread(new Runnable(){
@Override
public void run(){
        progressBar.setProgress(10);
        }
        });

        whileConnRobotAP=true;
        btnStartClick2=false;
        if(step1go){
        startUdp();
        }

        }
        }else{

        if(btnStartClick2){
        Log.e(TAG,"connRobotAPTime="+connRobotAPTime);
        addnet(robotAPSSID,robotAPSSIDPW);
        if(connRobotAPTime==ConnRobotAPMax){
        btnStartClick2=false;
        }
        }
        tvShowCurrentWifi.setText("您当前的网络："+stringssid);
        }
        //第一次udp1结束，开始第二次的udp
        if(reConnBeforWifiFlag){
        if(currentWifi.equals(stringssid)){
        //开始第10次的广播
        if(secondUdpRunOnce==0){
        secondUdpRunOnce=1;
        if(step2go){//如果按下了stop，step2go=false，接下来就不用做了
        SmartLinkActivity.this.runOnUiThread(new Runnable(){
@Override
public void run(){
        progressBar.setProgress(80);
        }
        });
        startUdp2();

        }

        }
        }
        }


        }else{


//                    tvShowCurrentWifi.setText("没有连接到wifi");
        //第一次连接到robotAP验证
//                    if(onCreateFlag){
//                        onCreateFlag = false;
//                        tvShowCurrentWifi.setText("没有连接到wifi");
//                    }
        if(!btnStartClick){
        btnSettingWifi.setVisibility(View.VISIBLE);
        tvShowCurrentWifi.setText("没有连接到wifi");
        }

        if(noConnRunOnce==0){
        noConnRunOnce=1;
        new Thread(){
@Override
public void run(){
        while(!whileConnRobotAP){
        if(flagConnSucessRobotAP==-1&&connRobotAPTime==ConnRobotAPMax){
        Log.e(TAG,"连接失败");
        myHandler.sendEmptyMessage(MSG_CONN_FAIL_1);
        connFirstWifi(currentWifi);
        whileConnRobotAP=true;
        btnTurn=false;
        SmartLinkActivity.this.runOnUiThread(new Runnable(){
@Override
public void run(){
        btnStart.setText(BUTTON_STRING_START);
        btnStart.setBackgroundResource(R.drawable.btn_bg);
        }
        });
        break;
        }
        }

        }
        }.start();
        }


        }
        }
        };
        //注册广播
        registerReceiver(mWifiChangedReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }

*/

