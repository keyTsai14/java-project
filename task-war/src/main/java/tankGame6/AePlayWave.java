package tankGame6;
/**
 * @author key
 */

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/2/17
 **/
public class AePlayWave extends Thread {
    private String filename;

    public AePlayWave(String waveFile) { // 构造器，指定文件
        filename = waveFile;
    }

    @Override
    public void run() {

        File soundFile = new File(filename);

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auLine = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,format);

        try {
            auLine = (SourceDataLine) AudioSystem.getLine(info);
            auLine.open(format);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        auLine.start();
        int nBytesRead = 0;
        // 这是缓存
        byte[] abData = new byte[512];

        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    auLine.write(abData, 0, nBytesRead);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            auLine.drain();
            auLine.close();
        }



    }
}
