package tankGame4;
/**
 * @author key
 */

import java.util.Vector;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/1/28
 **/
public class Hero extends Tank {
    // 定义Shot对象
    Shot shot = null;
    // 可以发射多颗子弹
    Vector<Shot> shots = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    // 射击
    static final int MAX_SHOT_NUM = 5;
    public void shotEnemyTank() {
        if (shots.size() == MAX_SHOT_NUM) {
            return;
        }

        // 创建shot对象，根据当前Hero对象的位置和方向来创建Shot
        switch (getDirection()) {
            case 0:
                shot = new Shot(getX() +20,getY(),0);
                break;
            case 1:
                shot = new Shot(getX() +60,getY() +20,1);
                break;
            case 2:
                shot = new Shot(getX() +20,getY() +60,2);
                break;
            case 3:
                shot = new Shot(getX(),getY() +20,3);
                break;
        }

        shots.add(shot);
        // 启动我们的Shot线程
        new Thread(shot).start();
    }
}
