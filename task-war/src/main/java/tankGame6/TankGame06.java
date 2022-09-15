package tankGame6;
/**
 * @author key
 */

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/1/28
 **/
public class TankGame06 extends JFrame {

    // 定义myPanel
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        TankGame06 tankGame06 = new TankGame06();
    }

    public TankGame06() {
        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);
        // 将 mp 放入Thread，并启动
        new Thread(mp).start();
        this.add(mp); // 把面板【游戏的绘图区域】

        this.setSize(1300,950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mp);

        // JFrame 中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }

}
