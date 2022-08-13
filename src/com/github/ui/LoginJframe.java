package com.github.ui;

import com.github.util.CodeUtil;

import javax.swing.*;

public class LoginJframe extends JFrame {

//    //创建一个集合存储在正确的用户名和密码
//    static ArrayList<User>list = new ArrayList<User>();
//    static{
//
//    }

    //LoginJframe 表示登录界面
    //以后所有跟登录相关的代码都写在这

    public LoginJframe() {
        //初始化界面
        initJFrame();

        //在这个界面添加内容
        initView();

        //设置界面显示
        this.setVisible(true);
    }

    //初始化界面
    public void initJFrame() {
        //在创建登录界面的时候，同时给这个界面去设置一些信息

        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }

    //在这个界面添加内容
    public void initView() {
        //1.添加用户文字
        JLabel usernameText = new JLabel(new ImageIcon("image/login/用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        JTextField username = new JTextField();
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("image/login/密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        JTextField password = new JTextField();
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon("image/login/验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码输入框
        JTextField code = new JTextField();
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);
        //生成验证码
        String codeStr = CodeUtil.getCode();
        JLabel rightCode = new JLabel();
        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300,256,50,30);
        //添加到桌面
        this.getContentPane().add(rightCode);
    }
}