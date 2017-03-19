package com.example;

import java.util.regex.Pattern;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/12/5<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class JavaClass {
    public static void main(String[] args){
        String add2  = "上海市上海市闵行区虹许路如旺电子商务有限公司虹许路如旺电子商务有限公司";
        String add  = "地址：上海市上海市闵行区红松东路1088";
        System.out.println("space="+getSubLengthAndSpaces(add,0)[1]);
        StringBuilder sb = new StringBuilder();

        /*
        int add_l = getSubLengthAndSpaces(add,26)[0];
        int add_spaces = getSubLengthAndSpaces(add,26)[1];
        if(add_spaces>26){
            add = add.substring(0,add_l);
//            System.out.println("l="+add_l+" add="+add);
        }
        int add_l_s = getSubLengthAndSpaces(add,14)[0];
        String add_frontString = add.substring(0,add_l_s);
        String add_backString = add.substring(add_frontString.length());
        sb.append(add_frontString).append("\n").append("      ");
        sb.append(add_backString).append("\n");
        System.out.println("sb="+"\n"+"地址："+sb.toString());
        */

        int add_l = getSubLengthAndSpaces(add,32)[0];//(16 -3)*2
        int add_spaces = getSubLengthAndSpaces(add,32)[1];
        if(add_spaces>32){
            add = add.substring(0,add_l);
        }
        int add_l_s = getSubLengthAndSpaces(add,16)[0];
        String add_frontString = add.substring(0,add_l_s);
        String add_backString = add.substring(add_frontString.length());
        sb.append(add_frontString).append("\n").append("      ");
        sb.append(add_backString).append("\n");
        System.out.println(""+sb.toString());
        System.out.println(".2="+String.format("%.02f",2.33333));




    }

    public static int[] getSubLengthAndSpaces(String s, int subLength) {
        int[] returnInts = {0, 0};
        int length;
        int chineseLength = 0;
        int not_chineseLength = 0;
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

            if ((chineseLength + not_chineseLength/2) == subLength) {
                ml = l;
            }

        }

        returnInts[0] = ml;
        not_chineseLength = (s.length() - chineseLength) / 2;
        length = not_chineseLength + chineseLength;
        returnInts[1] = length;
        return returnInts;
    }
}
