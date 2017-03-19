package com.example.test_class;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/12/9<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class Value {

    /*
    public static Value getInstance(){
        return new Value();
    }

    public int c = 0;


    public void inc() {
        c++;
    }
    */



    private static class ValueHolder {
        private static Value value = new Value();
    }


    private Value() {

    }


    public int c = 0;


    public void inc() {
        c++;
    }

    public static Value getInstance() {
        return ValueHolder.value;
    }




}



