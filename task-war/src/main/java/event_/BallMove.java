package event_;
/**
 * @author key
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Description 显示小球通过键盘控制上下左右 --》 java的事件控制
 * @Author admin
 * @Date 2022/1/29
 **/

// KeyListener 监听事件，监听键盘输入
public class BallMove extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    // 构造器
    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口JFrame 对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
    }


}

// 面板，可以画出小球
class MyPanel extends JPanel implements KeyListener {

    // 为了让小球可以移动，把他的左上角的坐标设置成变量
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    // 有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 有某个键按下，该方法就会触发
    @Override
    public void keyPressed(KeyEvent e) {

//        System.out.println((char)e.getKeyCode()+"被按下...");
        // 根据用户按下的不同键，来处理小球的移动（上下左右）
        // 在java中，会分给每一个键，分配一个值（int）
        if (e.getKeyCode() == KeyEvent.VK_DOWN) { // KeyEvent.VK_DOWN就是向下的箭头对应的code
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }


        // 让面板重绘
        this.repaint();

    }

    // 当某个键释放时，该方法就会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
