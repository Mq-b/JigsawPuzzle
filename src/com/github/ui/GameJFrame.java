package com.github.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    //JFrame 界面 窗体
    //子类? 也表示界面，窗体
    //规定: GameJFrame这个界面表示的就是游戏的主界面
    //以后跟游戏相关的所有逻辑都写在这个类中

    //创建一个二维数组
    //目的: 用来管理数据
    //加载图片的时候会根据二维数组加载
    int[][] data = new int[4][4];

    //记录空白方块在二维数组的位置
    int x = 0;
    int y = 0;

    public GameJFrame() {
        //初始化界面
        initJFram();

        //初始化菜单
        initJMenuBar();

        //初始化数据(打乱)
        initData();

        //初始化图片(根据打乱之后的结果去加载图片)
        initImage();

        //设置界面显示
        this.setVisible(true);
    }

    private void initData() {
        //1.定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的数据的顺序
        //遍历数组，得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随机索引
            int index = r.nextInt(tempArr.length);
            //拿着遍历到的每一个数据 跟随机索引上的数据进行交换
            var temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        //4.给二维数组添加数据
        //遍历一维数组得到的每一个元素，把每一个元素依次添加到二维数组当中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            } else {
                data[i / 4][i % 4] = tempArr[i];
            }
        }

    }

    //初始化图片
    //初始化图片的时候就需要按照二维数组中管理的数据添加图片
    private void initImage() {
        //清空原本已经出现的图片
        this.getContentPane().removeAll();

        //先加载的图片会在上方，后加载的在下方，且背景图片更大，所以需要先添加拼图的图片然后添加背景图片

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个JLabel的对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon("image/animal/animal3/" + data[i][j] + ".jpg"));
                //指定图片位置
                jLabel.setBounds(105 * j + 83, i * 105 + 134, 105, 105);
                //给图片添加边框(选择已有样式)我们使用的是斜面边框(0表示凸起，1则是凹下，可以使用定义好的常量)
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        JLabel backgroundLabel = new JLabel(new ImageIcon("image/background.png"));
        backgroundLabel.setBounds(40, 40, 508, 560);
        //把背景图片添加到界面中
        this.getContentPane().add(backgroundLabel);

        //刷新界面
        this.getContentPane().repaint();
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
        this.setSize(600, 680);

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

        //给整个界面添加键盘监听事件(参数为this表示触发后执行本类的代码)
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上下左右进行判断
        //左:37 上:38 右:39 下:40
        //移动图片位置是相对于空白反馈上的数字的位置，如向下移动就是把空白方块上面的图片向下移动

        int code = e.getKeyCode();
        if (code == 37) {
            if(y==3)
                return;
            System.out.println("向左移动");
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            initImage();
        } else if (code == 38) {
            if(x==3){
                //表示空白方块已经在最下面了，图片无法再移动,直接结束，不处理这个信号
                return;
            }
            System.out.println("向上移动");
            //更改二维数组然后调用initImage()是因为这个方法是根据二维数组来加载图片
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            //x y记载着空白图片的位置，既然移动了空白图片的位置，那么也要重新记录x++
            x++;
            //调用方法重写加载图片
            initImage();
        } else if (code == 39) {
            if(y==0)
                return;
            System.out.println("向右移动");
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            initImage();
        } else if (code == 40) {
            if(x==0)
                return;

            System.out.println("向下移动");
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            initImage();
        }
    }
}