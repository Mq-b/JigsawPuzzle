package com.github.ui;

import javax.swing.*;

public class LoginJframe extends JFrame{
    //LoginJframe 表示登录界面
    //以后所有跟登录相关的代码都写在这

    public LoginJframe(){
        //在创建登录界面的时候，同时给这个界面去设置一些信息
        //比如 宽高
        this.setSize(488,430);

        //设置界面标题
        this.setTitle("拼图 登录");

        //设置界面置顶(不被覆盖的意思)
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式(参数是底层定义的常量)
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置界面显示
        this.setVisible(true);

    }
}