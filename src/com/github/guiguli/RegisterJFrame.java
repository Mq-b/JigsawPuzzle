package com.github.guiguli;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //跟注册相关的代码，都写在这个界面中

    public RegisterJFrame(){
        //设置界面宽高
        this.setSize(488,500);

        //设置界面标题
        this.setTitle("拼图 注册");

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
