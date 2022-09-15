package tankGame4;
/**
 * @author key
 */

/**
 * @Description 坦克
 * @Author admin
 * @Date 2022/1/28
 **/
public class Tank {
    private int x;// 坦克横坐标
    private int y;// 坦克纵坐标
    private int direction; // 坦克方向
    private int speed = 1; // 坦克方向
    boolean isLive = true;


    // 上下左右移动方法
    public void moveUp(){
        y-=speed;
    }
    public void moveRight(){
        x+=speed;
    }

    public void moveDown(){
        y+=speed;
    }

    public void moveLeft(){
        x-=speed;
    }
    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
