package draw;
/**
 * @author key
 */

import javax.swing.*;
import java.awt.*;

/**
 * @Description 在面板上画圆
 * @Author admin
 * @Date 2022/1/28
 **/
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{ // JFrame 对应窗口

    // 定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        // 初始化面板
        mp = new MyPanel();
        // 把面板放入到窗口（画框）
        this.add(mp);
        // 设置窗口的大小
        this.setSize(400,300);
        // 当点击窗口的小叉叉,程序真正退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // 可以显示
    }

}

/**
 * 1. 先定义一个MyPanel，继承JPanel类，画图形，就在面板上画
 **/
class MyPanel extends JPanel {

    /**
     * 说明：
     * 1. MyPanel 对象就是一个面板
     * 2. Graphics g 把 g 理解成一支画笔
     * 3. Graphics 提供了很多绘图的方法
     * Graphics g
     **/

    @Override
    public void paint(Graphics g) { // 绘图方法
        super.paint(g); // 调用父类的方法完成初始化
//        System.out.println("paint方法被调用");
        // 画出一个圆形
//        g.drawOval(10,10,100,100);

        // Graphics类 常用方法
//        // 画出直线
//        g.drawLine(10,10,100,100);
        // 画出矩形边框
//        g.drawRect(10,10,100,100);
        // 填充矩形/椭圆,先设置颜色，在画图形
//        g.setColor(Color.blue);
//        g.fillRect(10,10,100,100);
//        g.fillOval(10,10,100,100);

        /**
         * 画图片
         * 1. 获取图片资源
         **/
//        System.out.println(Panel.class.getResource("/"));
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/微信图片_20211026144816.jpg"));
//        g.drawImage(image,10,10,175,221,this);
        // 画字符串
//        g.setColor(Color.RED);
//        g.setFont(new Font("隶书",Font.BOLD, 50));
//        g.drawString("阿粲你好",100,100);


    }
}