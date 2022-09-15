package tankGame6;
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
    // 增加成员，EnemyTank 可以得到敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    /**
     * 这里提供一个方法，可以将MyPanel 对象的成员 Vector<EnemyTank> enemyTanks = new Vector<>();
     * 设置到 EnemyTank 的成员 enemyTanks
     * */
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    /**
     * 编写方法，判断当前的这个敌人坦克，是否和 enemyTanks 中的其他坦克发生了重叠或者碰撞
     * */
    public boolean isTouchEnemyTank(){

        // 判断当前敌人坦克（this）方向
        switch (this.getDirection()) {
            case 0:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 从 Vector 中取出一个敌人tank
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {
                        /**
                         * 如果敌人坦克是上/下
                         *
                         * 1、如果敌人坦克是上/下，x的范围 [enemyTank.getX(),enemyTank.getX()+40]
                         *                       y的范围 [enemyTank.getY(),enemyTank.getX()+60]
                         **/
                        if (enemyTank.getDirection()==0 || enemyTank.getDirection()==2) {
                            // 2、 当前坦克 左上角的坐标 (this.getX(),this.getY())
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+60) {
                                return true;
                            }

                            // 3、 当前坦克 右上角的坐标 (this.getX()+40,this.getY())
                            if (this.getX()+40>=enemyTank.getX()
                                    && this.getX()+40<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是右/左
                        // 1、如果敌人坦克是右/左，x的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //                        y的范围 [enemyTank.getY(),enemyTank.getX()+40]
                        if (enemyTank.getDirection()==1 || enemyTank.getDirection()==3) {

                            // 2、 当前坦克 左上角的坐标 (this.getX(),this.getY())
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+40) {
                                return true;
                            }

                            // 3、 当前坦克 右上角的坐标 (this.getX()+40,this.getY())
                            if (this.getX()+40>=enemyTank.getX()
                                    && this.getX()+40<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:

                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 从 Vector 中取出一个敌人tank
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {
                        /**
                         * 如果敌人坦克是上/下
                         *
                         * 1、如果敌人坦克是上/下，x的范围 [enemyTank.getX(),enemyTank.getX()+40]
                         *                       y的范围 [enemyTank.getY(),enemyTank.getX()+60]
                         **/
                        if (enemyTank.getDirection()==0 || enemyTank.getDirection()==2) {
                            // 2、 当前坦克 右上角的坐标 (this.getX()+60,this.getY())
                            if (this.getX()+60>=enemyTank.getX()
                                    && this.getX()+60<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+60) {
                                return true;
                            }

                            // 3、 当前坦克 右下角的坐标 (this.getX()+60,this.getY()+40)
                            if (this.getX()+60>=enemyTank.getX()
                                    && this.getX()+60<=enemyTank.getX()+40
                                    && this.getY()+40>=enemyTank.getY()
                                    && this.getY()+40<=enemyTank.getY()+60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是右/左
                        // 1、如果敌人坦克是右/左，x的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //                        y的范围 [enemyTank.getY(),enemyTank.getX()+40]
                        if (enemyTank.getDirection()==1 || enemyTank.getDirection()==3) {

                            // 2、 当前坦克 右上角的坐标 (this.getX()+60,this.getY())
                            if (this.getX()+60>=enemyTank.getX()
                                    && this.getX()+60<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+40) {
                                return true;
                            }

                            // 3、 当前坦克 右下角的坐标 (this.getX()+60,this.getY()+40)
                            if (this.getX()+60>=enemyTank.getX()
                                    && this.getX()+60<=enemyTank.getX()+60
                                    && this.getY()+40>=enemyTank.getY()
                                    && this.getY()+40<=enemyTank.getY()+40) {
                                return true;
                            }
                        }
                    }
                }

                break;
            case 2:

                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 从 Vector 中取出一个敌人tank
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {
                        /**
                         * 如果敌人坦克是上/下
                         *
                         * 1、如果敌人坦克是上/下，x的范围 [enemyTank.getX(),enemyTank.getX()+40]
                         *                       y的范围 [enemyTank.getY(),enemyTank.getX()+60]
                         **/
                        if (enemyTank.getDirection()==0 || enemyTank.getDirection()==2) {
                            // 2、 当前坦克 左下角的坐标 (this.getX(),this.getY()+60)
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+40
                                    && this.getY()+60>=enemyTank.getY()
                                    && this.getY()+60<=enemyTank.getY()+60) {
                                return true;
                            }

                            // 3、 当前坦克 右下角的坐标 (this.getX()+40,this.getY()+60)
                            if (this.getX()+40>=enemyTank.getX()
                                    && this.getX()+40<=enemyTank.getX()+40
                                    && this.getY()+60>=enemyTank.getY()
                                    && this.getY()+60<=enemyTank.getY()+60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是右/左
                        // 1、如果敌人坦克是右/左，x的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //                        y的范围 [enemyTank.getY(),enemyTank.getX()+40]
                        if (enemyTank.getDirection()==1 || enemyTank.getDirection()==3) {

                            // 2、 当前坦克 左下角的坐标 (this.getX(),this.getY()+60)
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+60
                                    && this.getY()+60>=enemyTank.getY()
                                    && this.getY()+60<=enemyTank.getY()+40) {
                                return true;
                            }

                            // 3、 当前坦克 右下角的坐标 (this.getX()+40,this.getY()+60)
                            if (this.getX()+40>=enemyTank.getX()
                                    && this.getX()+40<=enemyTank.getX()+60
                                    && this.getY()+60>=enemyTank.getY()
                                    && this.getY()+60<=enemyTank.getY()+40) {
                                return true;
                            }
                        }
                    }
                }

                break;
            case 3:

                for (int i = 0; i < enemyTanks.size(); i++) {
                    // 从 Vector 中取出一个敌人tank
                    EnemyTank enemyTank = enemyTanks.get(i);
                    // 不和自己比较
                    if (enemyTank != this) {
                        /**
                         * 如果敌人坦克是上/下
                         *
                         * 1、如果敌人坦克是上/下，x的范围 [enemyTank.getX(),enemyTank.getX()+40]
                         *                       y的范围 [enemyTank.getY(),enemyTank.getX()+60]
                         **/
                        if (enemyTank.getDirection()==0 || enemyTank.getDirection()==2) {
                            // 2、 当前坦克 左上角的坐标 (this.getX(),this.getY())
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+60) {
                                return true;
                            }

                            // 3、 当前坦克 左下角的坐标 (this.getX(),this.getY()+40)
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+40
                                    && this.getY()+40>=enemyTank.getY()
                                    && this.getY()+40<=enemyTank.getY()+60) {
                                return true;
                            }
                        }
                        // 如果敌人坦克是右/左
                        // 1、如果敌人坦克是右/左，x的范围 [enemyTank.getX(),enemyTank.getX()+60]
                        //                        y的范围 [enemyTank.getY(),enemyTank.getX()+40]
                        if (enemyTank.getDirection()==1 || enemyTank.getDirection()==3) {

                            // 2、 当前坦克 左上角的坐标 (this.getX(),this.getY())
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    && this.getY()<=enemyTank.getY()+40) {
                                return true;
                            }

                            // 3、 当前坦克 左下角的坐标 (this.getX(),this.getY()+40)
                            if (this.getX()>=enemyTank.getX()
                                    && this.getX()<=enemyTank.getX()+60
                                    && this.getY()+40>=enemyTank.getY()
                                    && this.getY()+40<=enemyTank.getY()+40) {
                                return true;
                            }
                        }
                    }
                }

                break;
        }

        return false;
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
                        if (getY()>0 && !isTouchEnemyTank()) {
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
                        if (getX() + 60 <1000 && !isTouchEnemyTank()) {
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
                        if (getY()+60<750 && !isTouchEnemyTank()) {
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
                        if (getX()>0 && !isTouchEnemyTank()) {
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