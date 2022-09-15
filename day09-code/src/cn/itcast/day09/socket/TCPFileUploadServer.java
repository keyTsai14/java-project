package cn.itcast.day09.socket;
/**
 * @author key
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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

        // 字节流读取
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf))!= -1) {
//            System.out.println(new String(buf,0,readLen));
//        }

        // 字符流读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);



        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello, client".getBytes());

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client");
        bufferedWriter.newLine();
        bufferedWriter.flush();


//        socket.shutdownOutput();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
