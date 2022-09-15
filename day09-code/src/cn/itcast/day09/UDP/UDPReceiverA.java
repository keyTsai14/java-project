package cn.itcast.day09.UDP;
/**
 * @author key
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/3/4
 **/
public class UDPReceiverA {

    public static void main(String[] args) throws IOException {
        // 1、创建一个 DatagramSocket 对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);

        // 2、构建一个 DatagramPacket 对象，准备接收数据
        byte[] buf = new byte[64];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // 3、调用 接收方法，将通过网络传输的 DatagramPacket 对象 填充到 packet 对象
        // 当数据包发送到 本机的9999端口时，就会接收数据，若没有数据，就会阻塞
        System.out.println("A端 等待数据...");
        socket.receive(packet);

        // 4、 可以把packet 进行拆包，取出数据，并显示
        int length = packet.getLength();
        byte[] data = packet.getData();

        String s = new String(data, 0, length);
        System.out.println(s);


        // 将需要发送的数据封装到 DatagramPacket对象
        data = "好的，明天见".getBytes();

        packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.121"), 9998);

        socket.send(packet);

        // 关闭数据
        socket.close();
        System.out.println("A端退出");

    }
}
