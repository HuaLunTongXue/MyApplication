package com.example.kevin_zhuang.myapplication;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/11/18<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
 class InterfaceTest{

     InterfaceTest(){}

     int one(int a)throws TestError{

        if(a>5){
            throw new TestError("不能大于5");
        }


        return 0;
    }

}
