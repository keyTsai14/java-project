package tankGame4;
/**
 * @author key
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageProducer;
import java.util.Vector;

/**
 * @Description 坦克绘图区
 * @Author admin
 * @Date 2022/1/28
 **/
// 为了让Panel 不停的重绘子弹，需要将 MyPanel 实现 Runnable， 当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    // 定义我的坦克
    Hero hero = null;

    // 定义敌人的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize  = 3;

    // 定义一个Vector，存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    // 定义三张炸弹图片，实现爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        // 初始化自己坦克
        hero = new Hero(600,600);

        // 初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);
            new Thread(enemyTank).start();
            // 给该 enemyTank 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirection());
            // 加入 enemyTank 的 Vector 成员
            enemyTank.shots.add(shot);
            // 启动 shot 对象
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }

        // 初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/微信图片_20211026144816.jpg"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/微信图片_20211026144816.jpg"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/微信图片_20211026144816.jpg"));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750); // 填充矩形，默认黑色

        // 画出自己坦克 - 封装方法
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(),hero.getY(),g,hero.getDirection(),1);
        }

//        // 画出hero射击出的子弹 (一次一颗)
//        if (hero.shot != null && hero.shot.isLive ==  true) {
//            g.fill3DRect(hero.shot.x,hero.shot.y,3,3,false);
//        }

        // 将hero的子弹集合 shots ，遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot !=null && shot.isLive) {
                g.fill3DRect(shot.x,shot.y,3,3,false);
            } else {
                hero.shots.remove(shot);
            }
        }

        // 如果bombs 集合有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            // 根据当前这个bomb对象的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1,bomb.x,bomb.y,20,20,this);
            } else if (bomb.life > 3) {
                g.drawImage(image1,bomb.x,bomb.y,40,40,this);
            } else {
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }
            bomb.lifeDown();
            if (bomb.life==0) {
                bombs.remove(bomb);
            }
        }

        // 画出敌人的坦克 - 封装方法
        for (int i = 0; i < enemyTanks.size(); i++) {
            // 取出tank
            EnemyTank enemyTank = enemyTanks.get(i);
            // 要判断 tank是否存活
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirection(),0);
                // 画出 enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    // 取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    // 绘制
                    if (shot.isLive) {
                        g.fill3DRect(shot.x,shot.y,3,3,false);
                    } else {
                        // 从 Vector 移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
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

    // 判断子弹是否击中了敌人的tank
    public void hitEnemyTank() {
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            // 判断是否击中了敌人的tank
            if (shot != null && shot.isLive) { // 当我的子弹还活着
                // 遍历敌人的所有坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot,enemyTank);
                }
            }
        }
    }
    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                // 判断 shot 是否击中我的坦克
                if (hero.isLive && shot.isLive) {
                    hitTank(shot,hero);
                }
            }
        }
    }

    // 判断我方的子弹是否击中敌人坦克
    public void hitTank(Shot s, Tank tank) {
        // 判断s 击中坦克
        switch (tank.getDirection()) {
            case 0:
            case 2:
                if (s.x > tank.getX() && s.x < tank.getX()+ 40
                    && s.y > tank.getY() && s.y < tank.getY()+ 60) {
                    s.isLive = false;
                    tank.isLive = false;
                    // 子弹击中tank，要从集合中删去
                    enemyTanks.remove(tank);
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (s.x > tank.getX() && s.x < tank.getX()+ 60
                        && s.y > tank.getY() && s.y < tank.getY()+ 40) {
                    s.isLive = false;
                    tank.isLive = false;
                    // 子弹击中tank，要从集合中删去
                    enemyTanks.remove(tank);
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            if (hero.getY()>0) {
                hero.moveUp();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            if (hero.getX()+60<1000) {
                hero.moveRight();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            if (hero.getY()+60<750) {
                hero.moveDown();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirection(3);
            if (hero.getX()>0) {
                hero.moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            // 判断hero的子弹是否销毁(一次一颗)
//            if (hero.shot == null || !hero.shot.isLive) {
//                hero.shotEnemyTank();
//            }

            hero.shotEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { // 每个100毫秒，重绘绘图区域，让子弹有移动的效果
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 是否击中敌人
            hitEnemyTank();
            // 敌人是否击中我
            hitHero();
            this.repaint();
        }

    }
}
