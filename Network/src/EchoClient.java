import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
    //声明变量
    private DatagramSocket socket = null;
    private String serverIP; //客户端地址
    private int serverPort;// 客户端端口号


    //构造方法
    public EchoClient(String serverIP, int serverPort) throws SocketException {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    //构造启动方法
    public void start() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("客户端启动！");
        while (true) {
            //从控制台读取用户输入的内容
            System.out.print("->");
            String request = in.next();
            //构造 UDP 请求，并发送
            DatagramPacket reqPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIP),serverPort);
            socket.send(reqPacket);
            // 读取服务器的相应
            DatagramPacket respPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(respPacket);
            String response = new String(respPacket.getData(),0,respPacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        EchoClient echoClient = new EchoClient("127.0.0.1", 9090);
        echoClient.start();
    }

}
