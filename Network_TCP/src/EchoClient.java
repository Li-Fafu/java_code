import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket socket;

    public EchoClient(String serverIP, int serverPort) throws IOException {
        // 在 new 这个对象的时候就涉及到 "建立连接操作"
        // 由于连接建立好了之后, 服务器的信息就在操作系统中被 TCP 协议记录了. 我们在应用程序层面上就不需要保存 IP 和 端口.
        socket = new Socket(serverIP, serverPort);
    }

    //定义 start 方法
    public void start(){
        System.out.println("客户端启动！");

        Scanner scanner = new Scanner(System.in);

        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            Scanner scannerNet = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream);
            while(true){
                //获取输入
                System.out.print(">");
                String request = scanner.next();
                //构造请求发送给服务器.
                writer.println(request);
                //刷新缓冲区
                writer.flush();
                //读取服务器的响应.
                if(!scannerNet.hasNext()){
                    System.out.println("服务器断开连接！");
                    break;
                }
                String response = scannerNet.next();
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        EchoClient echoClient = new EchoClient("127.0.0.1",9090);
        echoClient.start();
    }
}
