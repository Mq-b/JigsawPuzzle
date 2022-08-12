package com.github.ui;

import javax.swing.*;

public class GameJFrame extends JFrame {
    //JFrame 界面 窗体
    //子类? 也表示界面，窗体
    //规定: GameJFrame这个界面表示的就是游戏的主界面
    //以后跟游戏相关的所有逻辑都写在这个类中

    public GameJFrame(){
        //初始化界面
        initJFram();

        //初始化菜单
        initJMenuBar();

        //初始化图片
        initImage();

        //设置界面显示
        this.setVisible(true);
    }

    //初始化图片
    private void initImage() {
        for(int i = 0,number=1; i < 4; i++) {
            for (int j = 0; j < 4; j++,number++) {
                //创建一个JLabel的对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon("image/animal/animal3/" + (number) + ".jpg"));
                //指定图片位置
                jLabel.setBounds(105 * j, i*105, 105, 105);
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }
    }

    //初始化菜单
    private void initJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象(功能 关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新登录游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录游戏");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将每一个选项下面的条目天极爱到选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initJFram() {
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

        //取消默认的居中放置图片，只有取消了才会按照xy轴形式添加组件
        this.setLayout(null);
    }
}