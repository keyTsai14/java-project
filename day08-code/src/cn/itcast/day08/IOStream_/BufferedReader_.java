package cn.itcast.day08.IOStream_;
/**
 * @author key
 */

/**
 * @Description 做成包装流
 * @Author admin
 * @Date 2022/2/11
 **/
public class BufferedReader_ extends Reader_ {

    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_) {
         this.reader_ = reader_;
    }

    @Override
    public void readFile() {
         reader_.readFile();
    }

    public void readFiles(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    public void readStrings(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }

}
