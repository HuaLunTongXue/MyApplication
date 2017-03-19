package com.example;

import java.io.UnsupportedEncodingException;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2017/2/16<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class ATest {
    public static void main(String[] args){
        String a = "com.example.kevin_zhuang.fujidemo.MainActivity";
        String b = "com.example.kevin_zhuang.fujidemo.MainActivity";
        System.out.println("result="+a.equals(b));


        int aInt = 0x0A;
        int bInt = 0x14;
        int cInt = 0x28;
        int dInt = 0x1E;
        int aInt2 = 50;
        byte aByte = Byte.parseByte("10");

        String data = "3132333435363738";
        char[] chardata = data.toCharArray();




        System.out.println("aInt="+aInt+" bInt="+bInt+" cInt="+cInt+" dInt="+dInt+" hexDint="+Integer.toHexString(dInt));
        System.out.println("aByte="+chardata[0]);
        System.out.println("aByte="+(int)aByte);

        byte waterFlow[] = {(byte)0x01,(byte)0x90};
        System.out.println("waterFlow="+bytes2HexString(waterFlow));

        int w = 400;
        byte[] tempp = Integer.toHexString(w).getBytes();
        byte[] tempp2 = new byte[2];

        //10进制
        byte devBin = (byte) Integer.parseInt("255", 10);
        byte devBin2 = (byte) Integer.parseInt("11", 10);

        tempp2[0]=devBin;
        tempp2[1]=devBin2;


        int aaa= 65535;
        String hexString  = Integer.toHexString(aaa);

//        if((hexString.length()%2)==1){
//            hexString = "0"+hexString;
//            System.out.println("==1");
//        }
        byte[] tempp3 = HexString2Bytes(hexString);

        System.out.println("HexString="+Integer.toHexString(aaa));


        System.out.println("waterFlow="+bytes2HexString(tempp2));

        String realHexString = "0190";
        System.out.println("16进制转10进制="+Integer.parseInt(realHexString,16));
        System.out.println("16进制转10进制="+Integer.parseInt(realHexString.substring(2,4),16));
        System.out.println("16进制转10进制="+realHexString.substring(2,4));


        String AllData = "00 12 34 31 32 33 34 35 36 37 38 00 01 01 2C 32 00 00 00 00 78 04";
        System.out.println("16进制转10进制 0190="+HexString2Dec("0190"));
        String re = ""+Integer.parseInt("31",10);


        String data2 = "31 32 33 34 35 36 37 38";//12345678
        String[] data3= data2.split(" ");
        char[] data4 =  new char[data3.length];
        for (int i = 0; i < data4.length; i++) {
            data4[i] = (char)(Integer.parseInt(data3[i],16));
        }
        String str = new String(data4);
        System.out.println("16进制转10进制========="+asciiString2Decs(data2.replace(" ","")));


        System.out.println("16进制转10进制="+re);

    }


    /**
     * ascii码字符串转 10进制 字符串
     * "31 32 33 34 35 36 37 38" to "12345678"
     * @param hexString
     * @return
     */
    public static String asciiString2Decs(String hexString){
        String ret;
        int length = hexString.length();
        char[] charData =  new char[length/2];
        for (int i = 0; i < charData.length; i++) {
            charData[i] = (char)(Integer.parseInt(hexString.substring(2*i,2*i+2),16));
        }
        ret = new String(charData);
        return  ret;
    }

    /**
     * 16进制字符串转byte数组
     * @param hexString 16进制字符串
     * @return byte数组
     */
    public static byte[] HexString2Bytes(String hexString) {
        int stringLength = hexString.length();
        //新加判断
        if((stringLength%2)==1){
//            如果是奇数
            hexString = "0"+hexString;
            stringLength +=1;
        }
        //
        byte[] data = new byte[(stringLength / 2)];
        for (int i = 0, j = 0; i < data.length; i++, j = j + 2) {
            data[i] = (byte) Integer.parseInt(hexString.substring(j, (j + 2)), 16);
        }
        return data;
    }


    private static String HexString2Dec(String hexString) {

        String ret = "";
        int length = hexString.length();
        for(int i = 0;i<length;i+=2){
            ret += Integer.parseInt(hexString.substring(i,i+2),16)+" ";
        }

        return ret;
    }

    private static String bytes2HexString(byte[] b) {        //byte转16进制字符串函数
        String ret = "";
        for (byte aB : b) {
            String hex = Integer.toHexString(aB & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

}
