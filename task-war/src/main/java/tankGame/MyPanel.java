package tankGame;
/**
 * @author key
 */

import javax.swing.*;
import java.awt.*;

/**
 * @Description 坦克绘图区
 * @Author admin
 * @Date 2022/1/28
 **/
public class MyPanel extends JPanel {
    // 定义我的坦克
    Hero hero = null;
    public MyPanel() {
        hero = new Hero(100,100);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750); // 填充矩形，默认黑色

        // 画出坦克 - 封装方法
        drawTank(hero.getX(),hero.getY(),g,0,0);

    }

    /**
     * @Description 编写方法，画出坦克
     * x 坦克的左上角x坐标
     * y 坦克的左上角y坐标
     * g 画笔
     * direction 坦克方向（上下左右）
     * type 坦克类型
     * @return void
     **/
    public void drawTank(int x, int y, Graphics g, int direction, int type) {

        // 根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0:// 我们的坦克
                g.setColor(Color.CYAN);
                break;
            case 1:// 敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克的方向，来绘制坦克
        switch (direction) {
            case 0:// 上
                g.fill3DRect(x,y,10,60,false);// 画出坦克左边的论子
                g.fill3DRect(x + 30,y,10,60,false);// 画出坦克右边的论子
                g.fill3DRect(x + 10,y + 10,20,40,false);// 画出坦克身体
                g.fillOval(x + 10,y + 20,20,20);// 画出坦克盖子
                g.drawLine(x + 20,y + 30,x+20,y);// 画出坦克盖子

                break;
            case 1:break;
            case 2:break;
            case 3:break;
            default:break;
        }

    }

}
