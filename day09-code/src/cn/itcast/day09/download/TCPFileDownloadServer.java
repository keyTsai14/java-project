package cn.itcast.day09.download;
/**
 * @author key
 */

import cn.itcast.day09.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 服务端，文件下载
 * @Author admin
 * @Date 2022/3/3
 **/
public class TCPFileDownloadServer {

    public static void main(String[] args) throws IOException {

        // 1 监听，等待客户端连接，并发送下载文件的名字
        ServerSocket serverSocket = new ServerSocket(9999);
        // 2 等待客户端连接
        Socket socket = serverSocket.accept();

        // 3 读取 客户端发送要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downloadFileName = "";
        while ((len = inputStream.read(b))!=-1) {
            downloadFileName += new String(b,0,len);
        }
        System.out.println("客户端希望下载的文件名："+downloadFileName);

        String resFileName = "";
        if ("xxx".equals(downloadFileName)) {
            resFileName = "D:\\myRecord.txt";
        } else {
            resFileName = "D:\\qie2.png";
        }


        // 4 创建一个输入流，读取文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));

        // 5 使用工具类，读取文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        // 6 得到Socket 关联的 输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        // 7 写入到数据通道
        bos.write(bytes);
        socket.shutdownOutput();

        bos.close();
        bufferedInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

        System.out.println("服务器退出...");

    }
}
