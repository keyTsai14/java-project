package tankGame4;
/**
 * @author key
 */

import java.util.Vector;

/**
 * @Description 敌人的坦克
 * @Author admin
 * @Date 2022/1/29
 **/
public class EnemyTank extends Tank implements Runnable {
    // 在敌人坦克类，使用 Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {

            if (isLive && shots.size() < 1) {

                Shot s = null;
                // 判断tank的方向，创建对应的方向
                switch (getDirection()) {
                    case 0:
                        s = new Shot(getX()+20, getY(),0);
                        break;
                    case 1:
                        s = new Shot(getX()+60, getY()+20,1);
                        break;
                    case 2:
                        s = new Shot(getX()+20, getY()+60,2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY()+20,3);
                        break;
                }

                shots.add(s);
                new Thread(s).start();

            }

            // 根据坦克的方向来继续移动
            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY()>0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 <1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY()+60<750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX()>0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 然后随机的改变tank方向
            setDirection((int) (Math.random()*4));

            if (!isLive) {
                break;
            }
        }
    }
}


/**
 * 因为敌人的坦克，是在 MyPanel 上，所以我们的代码在 MyPanel
 * 因为敌人的坦克，后面有自己特殊的属性和方法，可以单开一个 EnemyTank
 * 敌人坦克数量多，可以放入到集合 Vector，因为考虑多线程问题
 **/