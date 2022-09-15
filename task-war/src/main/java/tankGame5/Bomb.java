package tankGame5;
/**
 * @author key
 */

/**
 * @Description 炸弹
 * @Author admin
 * @Date 2022/2/8
 **/
public class Bomb {
    int x,y; //炸弹坐标
    int life = 9; // 生命周期
    boolean isLive = true; // 是否还存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 减少生命
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
