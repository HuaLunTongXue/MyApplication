package com.example.kevin_zhuang.myapplication;

import android.graphics.Color;

import com.example.kevin_zhuang.myapplication.annotation.FruitColor;
import com.example.kevin_zhuang.myapplication.annotation.FruitName;
import com.example.kevin_zhuang.myapplication.annotation.FruitProvider;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/11/18<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class Apple {

    @FruitName("FuShi Apple")
    public String fruitName;

    @FruitColor(fruitColor = FruitColor.Color.WHITE)
    public String fruitColor;

    @FruitProvider(id = 1,user = "kevin",address = "China")
    public FruitProvider mFruitProvider;

    private Apple(){}




}
