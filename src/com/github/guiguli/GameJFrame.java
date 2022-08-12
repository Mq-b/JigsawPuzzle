package com.github.guiguli;

import javax.swing.*;

public class GameJFrame extends JFrame {
    //JFrame 界面 窗体
    //子类? 也表示界面，窗体
    //规定: GameJFrame这个界面表示的就是游戏的主界面
    //以后跟游戏相关的所有逻辑都写在这个类中

    public GameJFrame(){
        //设置界面宽高
        this.setSize(600,680);

        //设置界面标题
        this.setTitle("拼图单机版 v1.0");

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
