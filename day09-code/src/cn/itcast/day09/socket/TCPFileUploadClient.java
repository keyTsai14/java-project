package cn.itcast.day09.socket;
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

        // 字节流写法
//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello, server".getBytes());
//
//        socket.shutdownOutput();
        // 字符流写法
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server");
        bufferedWriter.newLine(); // 这里表示接内容结束，并要求对方使用readLine()
        bufferedWriter.flush(); // 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道




        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(buf))!= -1) {
//            System.out.println(new String(buf,0,readLen));
//        }
        // 字符流读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();


    }
}
