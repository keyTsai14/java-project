package tankGame2;
/**
 * @author key
 */

import javax.swing.*;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/1/28
 **/
public class TankGame02 extends JFrame {

    // 定义myPanel
    MyPanel mp = null;
    public static void main(String[] args) {

        TankGame02 tankGame02 = new TankGame02();
    }

    public TankGame02() {
        mp = new MyPanel();
        this.add(mp); // 把面板【游戏的绘图区域】
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);
    }

}
