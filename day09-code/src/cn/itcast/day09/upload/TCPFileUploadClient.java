package cn.itcast.day09.upload;
/**
 * @author key
 */

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description 客户端，通过网络上传图片到服务器
 * @Author admin
 * @Date 2022/3/3
 **/
public class TCPFileUploadClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("客户端 socket=" + socket.getClass());

        // 创建读取磁盘文件的输入流
        String filePath = "D:\\aoe\\chuanyun_5f795c14-c934-49b0-8ca2-cba5fd72e4e1\\67cd014c25a94f208a048513.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = StreamUtils.streamToByteArray(bis);

        // 通过socket获取到输出流，将bytes数据发送到服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes); // 将文件对应的字节数组的内容，写入到数据通道
        bis.close();
        socket.shutdownOutput();

        // 回复的消息、
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        bos.close();
        socket.close();

    }
}
