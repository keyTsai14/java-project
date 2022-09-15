package cn.itcast.day09.download;
/**
 * @author key
 */

import cn.itcast.day09.upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description 客户端
 * @Author admin
 * @Date 2022/3/3
 **/
public class TCPFileDownloadClient {

    public static void main(String[] args) throws IOException {

        // 1 接收用户输入，指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名称");
        String downloadFileName = scanner.next();

        // 2 客户端连接服务器，准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 3 获取和socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        // 写入结束标识
        socket.shutdownOutput();

        // 4 读取服务器返回的文件（字节数据）
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        // 5 得到一个输出流，准备将数据写入到磁盘
        String filePath = "d:\\aoe\\" + downloadFileName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);

        // 6 关闭相关的资源
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();

        System.out.println("客户端关闭。。。");

    }
}
