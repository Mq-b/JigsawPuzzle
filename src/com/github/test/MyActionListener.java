package com.github.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//实现动作接口
public class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了");
    }
}
