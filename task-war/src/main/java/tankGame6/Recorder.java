package tankGame6;
/**
 * @author key
 */

import java.io.*;
import java.util.Vector;

/**
 * @Description 该类用于记录相关信息的，和文件交互
 * @Author admin
 * @Date 2022/2/17
 **/
public class Recorder {

    // 定义变量，记录我方击毁坦克数
    private static int allEnemyTankNum = 0;
    // 定义IO对象
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "myRecord.txt";

    // 定义vector，指向myPanel 对象的 敌人坦克Vector
    private static Vector<EnemyTank> enemyTanks = null;

    private static Vector<Node> nodes = new Vector<>();

    public static String getRecordFile() {
        return recordFile;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    // 增加一个方法，用于读取recordFile，恢复相关信息
    public static Vector<Node> getNodesAndEnemyTankRec() {

        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());

            // 循环读取文件，生成 nodes 集合
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] split = line.split(" ");
                Node node = new Node(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                nodes.add(node);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return nodes;
    }


    // 当游戏退出时，将 allEnemyTankNum 保存到  recordFile
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");
//            bw.newLine();

            // 遍历敌人坦克的Vector，然后根据情况保存即可。
            // OOP, 定义一个属性，然后通过set方法得到 敌人坦克的 Vector
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive) {
                    // 保存该enemyTank信息
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                    // 写入到文件
                    bw.write(record + "\r\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    // 当我方坦克击毁一台坦克时，应当 allEnemyTankNum++
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }
}
