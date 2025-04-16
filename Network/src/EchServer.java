import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class EchServer {
    //声明socket变量名
    private DatagramSocket socket;

    //构造方法
    public EchServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    //服务器的主要逻辑，封装为start
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while(true){
            // 1. 读取请求并解析
            //1.1 创建空白的 DatagramPacket 对象
            DatagramPacket reqPacket = new DatagramPacket(new byte[4096], 4096);
            //1.2 通过 receive 读取网卡中的数据，如果没有数据，则会阻塞等待
            socket.receive(reqPacket);
            // 1.3 把 DatagramPacket 中的数据解析成字符串. 只需要从 DatagramPacket 取到有效的数据即可.
            String request = new String(reqPacket.getData(), 0, reqPacket.getLength());
            // 2. 根据请求计算响应
            String response = process(request);
            // 3. 把响应写回到客户端
            // 3.1 把响应构造成 DatagramPacket 对象
            DatagramPacket respPacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    reqPacket.getAddress(), reqPacket.getPort());
            // 3.2 把 DatagramPacket 写回到客户端.
            socket.send(respPacket);
            // 4. 打印日志.
            System.out.printf("[%s:%d] req: %s, resp: %s\n",
                    reqPacket.getAddress(), reqPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        EchServer server = new EchServer(9090);
        server.start();
    }

}