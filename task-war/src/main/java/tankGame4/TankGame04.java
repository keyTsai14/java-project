package tankGame4;
/**
 * @author key
 */

import javax.swing.*;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/1/28
 **/
public class TankGame04 extends JFrame {

    // 定义myPanel
    MyPanel mp = null;
    public static void main(String[] args) {

        TankGame04 tankGame04 = new TankGame04();
    }

    public TankGame04() {
        mp = new MyPanel();
        // 将 mp 放入Thread，并启动
        new Thread(mp).start();
        this.add(mp); // 把面板【游戏的绘图区域】
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }

}
