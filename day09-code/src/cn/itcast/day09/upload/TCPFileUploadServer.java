package cn.itcast.day09.upload;
/**
 * @author key
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

/**
 * @Description 服务端，回复消息
 * @Author admin
 * @Date 2022/3/3
 **/
public class TCPFileUploadServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端 在8888端口监听， 等待连接");

        Socket socket = serverSocket.accept();

        System.out.println("服务器 socket=" + socket.getClass());

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        byte[] bytes = StreamUtils.streamToByteArray(bis);
        String destFilePath = "D:\\qie2.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        // 向客户端 回复 收到照片
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到照片");
        writer.flush();
        socket.shutdownOutput();

        writer.close();
        bis.close();

        socket.close();
        serverSocket.close();

    }
}
