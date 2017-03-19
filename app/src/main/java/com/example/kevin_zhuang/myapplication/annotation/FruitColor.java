package com.example.kevin_zhuang.myapplication.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/11/18<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    enum Color{RED,YELLOW,WHITE}
    Color fruitColor();
}
