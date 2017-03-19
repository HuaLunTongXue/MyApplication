package com.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2017/1/4<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class JavaFunTest {
    public static void main(String[] args){
        String url = "http://wantvmc.gz.bcebos.com/odoo10%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A/%E6%97%BA%E4%BB%94%E5%B0%8F%E9%A6%92%E5%A4%B42014%E3%80%8Aq%E5%AE%9D%E8%B4%9D%E7%AF%87%E3%80%8B30s%E9%9D%9E%E6%B4%BB%E5%8A%A8%E7%89%88-1.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2016-12-29T17%3A27%3A54Z%2F-1%2Fhost%2F74c3aaf069f8ec7f893a4d503707328d71de7701b2829e7f7459ebdc73975595";
        String url2 = "http://wantvmc.gz.bcebos.com/odoo10%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A/Qq%E7%B3%96%202016%20%E6%96%B0come%20On%20Baby%20%E5%8D%87%E7%BA%A730s-1.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2016-12-29T17%3A27%3A24Z%2F-1%2Fhost%2F102570e4e0bbe419ce0cef76a6d8681f7b586446c09518947253f683c649fa9e";
        String url3 = "http://wantvmc.gz.bcebos.com/odoo10%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A/2017-want-%E6%B4%BB%E5%8A%A8.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2016-12-30T12%3A04%3A22Z%2F-1%2Fhost%2F40d9e67102838429bac61331372a29e842e087f746800d9e7833896c15211bb7";
        String url4 = "http://wantvmc.gz.bcebos.com/odoo10%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A/2017_Hollywant%20New%20Year.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2016-12-29T17%3A26%3A00Z%2F-1%2Fhost%2Fa93e74e13b398f229d51cd21124c7ed0d20025f3e0681151a33d2d2ad027d1b4";

        String url5 = "http://wantvmc.gz.bcebos.com/O%E6%B3%A1%E6%9E%9C%E5%A5%B6%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2016-11-08T09%3A38%3A18Z%2F-1%2Fhost%2Fd59f823ede37a8c936110fae064206ba8503ab2b60f49362d3f62a14e4f2a98e";




        String video1 = "http://wantvmc.gz.bcebos.com/%E4%BC%9A%E5%B1%95%E4%B8%AD%E5%BF%83%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A/%E6%97%BA%E4%BB%94%E5%B0%8F%E9%A6%92%E5%A4%B4%E3%80%8A%E6%96%B0%E9%9A%8F%E6%97%B6%E9%9A%8F%E5%9C%B0%E7%AF%87%E3%80%8B30s%E5%85%A8%E5%9B%BD%E7%89%88-1-1.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2017-01-16T03%3A26%3A10Z%2F-1%2Fhost%2F184a73053e68aa29d27754a68a9a8c86e2ff97a544fa4a48a9eb898430a1c128";
        String video2 = "http://wantvmc.gz.bcebos.com/%E4%BC%9A%E5%B1%95%E4%B8%AD%E5%BF%83%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A/O%E6%B3%A1%E4%B9%90%E5%99%A8%E7%AF%87-%E5%B1%95%E4%BC%9A-1.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2017-01-16T03%3A27%3A19Z%2F-1%2Fhost%2F1d929e895467e7124df7726b2781a4d1e7293889729fa7bc8f09a5d250ec9bf7";
        String video3 = "http://wantvmc.gz.bcebos.com/%E4%BC%9A%E5%B1%95%E4%B8%AD%E5%BF%83%E8%A7%86%E9%A2%91%E5%B9%BF%E5%91%8A/F%E6%97%BA%E4%BB%94%E7%89%9B%E5%A5%B6%E3%80%8A%E5%8F%97%E4%B8%8D%E4%BA%86%E7%AF%87-%E7%89%B9%E6%B5%93%E7%89%88%E3%80%8B30s-1.mp4?authorization=bce-auth-v1%2F4c95b9991c4a477a9b38a05b28fa1e4c%2F2017-01-16T03%3A26%3A48Z%2F-1%2Fhost%2F80110d0d2664435ce3b131027be455b8a68094d434203cb862dfffdbc29f4370";
        System.out.println("md5="+md5(url5));
        System.out.println("md5  1="+md5(video1));
        System.out.println("md5  2="+md5(video2));
        System.out.println("md5  3="+md5(video3));


        try {
            URL url1 = new URL(video2);
            HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
            con1.setConnectTimeout(3000);
            con1.setReadTimeout(3000);
            int len = con1.getContentLength();
            System.out.println("len ====== "+len);
        } catch (IOException e) {
            e.printStackTrace();
        }




        String data  = "AppLE";
        if(data.contentEquals("AppLE")){
            System.out.println("YES");
        }

    }


    private static String md5(String str) {
        StringBuffer buffer = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] byts = md.digest(str.getBytes(Charset.forName("utf-8")));
            for (byte byt : byts) {
                int d = byt & 0xFF;
                if (d < 16) {
                    buffer.append(0);
                }
                buffer.append(Integer.toHexString(d));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
