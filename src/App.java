import com.github.guiguli.GameJFrame;
import com.github.guiguli.LoginJframe;
import com.github.guiguli.RegisterJFrame;

public class App {
    public static void main(String[] args) {
        //表示程序的启动入口

        //如果我们想要开启一个界面，就创建谁的对象就可以
        new LoginJframe();

        new RegisterJFrame();

        new GameJFrame();
    }
}
