package tankGame2;
/**
 * @author key
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Description 坦克绘图区
 * @Author admin
 * @Date 2022/1/28
 **/
public class MyPanel extends JPanel implements KeyListener {
    // 定义我的坦克
    Hero hero = null;

    // 定义敌人的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize  = 3;
    public MyPanel() {
        hero = new Hero(100,100);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750); // 填充矩形，默认黑色

        // 画出自己坦克 - 封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirection(),1);

        // 画出自己坦克 - 封装方法
        for (int i = 0; i < enemyTankSize; i++) {
            // 取出tank
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirection(),0);
        }

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
            case 0:// 敌人的坦克
                g.setColor(Color.CYAN);
                break;
            case 1:// 我们的坦克
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克的方向，来绘制对应形状的坦克
        // direction 表示方向（0-上 1-右 2-下 3-左）
        switch (direction) {
            case 0:// 上
                g.fill3DRect(x,y,10,60,false);// 画出坦克左边的论子
                g.fill3DRect(x + 30,y,10,60,false);// 画出坦克右边的论子
                g.fill3DRect(x + 10,y + 10,20,40,false);// 画出坦克身体
                g.fillOval(x + 10,y + 20,20,20);// 画出坦克盖子
                g.drawLine(x + 20,y + 30,x+20,y);// 画出坦炮筒

                break;
            case 1:
                g.fill3DRect(x,y,60,10,false);// 画出坦克上边的论子
                g.fill3DRect(x,y + 30,60,10,false);// 画出坦克下边的论子
                g.fill3DRect(x + 10,y + 10,40,20,false);// 画出坦克身体
                g.fillOval(x + 20,y + 10,20,20);// 画出坦克盖子
                g.drawLine(x + 30,y + 20,x+60,y+20);// 画出坦炮筒

                break;
            case 2:
                g.fill3DRect(x,y,10,60,false);// 画出坦克左边的论子
                g.fill3DRect(x + 30,y,10,60,false);// 画出坦克右边的论子
                g.fill3DRect(x + 10,y + 10,20,40,false);// 画出坦克身体
                g.fillOval(x + 10,y + 20,20,20);// 画出坦克盖子
                g.drawLine(x + 20,y + 30,x+20,y+60);// 画出坦炮筒

                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);// 画出坦克上边的论子
                g.fill3DRect(x,y + 30,60,10,false);// 画出坦克下边的论子
                g.fill3DRect(x + 10,y + 10,40,20,false);// 画出坦克身体
                g.fillOval(x + 20,y + 10,20,20);// 画出坦克盖子
                g.drawLine(x + 30,y + 20,x,y+20);// 画出坦炮筒
                break;
            default:break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.moveUp();

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.moveRight();

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();

        } else if (e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirection(3);
            hero.moveLeft();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
