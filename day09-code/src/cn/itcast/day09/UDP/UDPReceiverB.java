package cn.itcast.day09.UDP;
/**
 * @author key
 */

import java.io.IOException;
import java.net.*;

/**
 * @Description TODO
 * @Author admin
 * @Date 2022/3/4
 **/
public class UDPReceiverB {

    public static void main(String[] args) throws IOException {

        // 准备发送和接收数据，在9998端口 接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        // 将需要发送的数据封装到 DatagramPacket对象
        byte[] data = "hello，明天吃火锅".getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.0.121"), 9999);

        socket.send(packet);


        // 2、构建一个 DatagramPacket 对象，准备接收数据
        byte[] buf = new byte[64];
        packet = new DatagramPacket(buf, buf.length);

        // 3、调用 接收方法，将通过网络传输的 DatagramPacket 对象 填充到 packet 对象
        // 当数据包发送到 本机的9999端口时，就会接收数据，若没有数据，就会阻塞
        System.out.println("A端 等待数据...");
        socket.receive(packet);

        // 4、 可以把packet 进行拆包，取出数据，并显示
        int length = packet.getLength();
        data = packet.getData();

        String s = new String(data, 0, length);
        System.out.println(s);



        socket.close();
        System.out.println("B端退出");
    }
}
