package cn.itcast.day09.upload;
/**
 * @author key
 */

import java.io.*;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/3/3
 **/
public class StreamUtils {

    /**
     * @Description stream转字节数组
     * @Param [is]
     * @return byte[]
     **/
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(); // 创建输出流对象
        byte[] b = new byte[1024];
        int len;
        while ((len=is.read(b))!=-1) {
            bos.write(b,0,len);
        }
        byte[] array = bos.toByteArray(); // 读取的内容转成 字节数组
        bos.close();
        return array;
    }


    /**
     * @Description stream转String
     * @Param [is]
     * @return java.lang.String
     **/
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }

}
