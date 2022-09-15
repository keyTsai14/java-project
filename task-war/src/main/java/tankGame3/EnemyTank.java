package tankGame3;
/**
 * @author key
 */

/**
 * @Description 敌人的坦克
 * @Author admin
 * @Date 2022/1/29
 **/
public class EnemyTank extends Tank {
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}


/**
 * 因为敌人的坦克，是在 MyPanel 上，所以我们的代码在 MyPanel
 * 因为敌人的坦克，后面有自己特殊的属性和方法，可以单开一个 EnemyTank
 * 敌人坦克数量多，可以放入到集合 Vector，因为考虑多线程问题
 **/