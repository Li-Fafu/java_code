import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class EchoServer {
    public ServerSocket serverSocket;

    public EchoServer(int port) throws IOException {
        //服务器启动就会绑定 port 服务器端口
        serverSocket = new ServerSocket(port);
    }

    //定义 start 方法
    public void start() throws IOException {
        System.out.println("服务器启动！");

        //创建线程池 保证多线程执行
        ExecutorService  threadPool = Executors.newCachedThreadPool();
        while(true){
            Socket socket =  serverSocket.accept();
            threadPool.submit(()->{
               processConnection(socket);
            });
        }


    }
    private void processConnection(Socket socket){
        System.out.printf("[%s:%d] 用户上线！\n",socket.getInetAddress().toString(),socket.getPort());
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputstream = socket.getOutputStream()){
            // 实现通信的代码.
            // 一个客户端可能会和服务器有多轮的请求响应交互.
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputstream);
            while(true){
                // 1. 读取请求并解析. 这个地方有更简单的办法.
                if(!scanner.hasNext()){
                    // 针对客户端下线逻辑的处理. 如果客户端断开连接了 (比如客户端结束了)
                    // 此时 hasNext 就会返回 false
                    // 如果是使用 read 方法, 就会出现返回 -1 的情况. 也可以用来判定客户端断开连接.
                    System.out.printf("[%s:%d] 用户下线！\n",socket.getInetAddress().toString(),socket.getPort());
                }

                // 没有执行到这个打印, 说明上面的 hasNext 没有解除阻塞. 大概率就是客户端没发来数据.
                //System.out.println("服务器收到数据了!");

                String request = scanner.next();
                // 2. 根据请求计算响应.
                String response = process(request);
                // 3. 把响应写回到客户端.
                writer.println(response);
                writer.flush();

                System.out.printf("[%s:%d] req: %s; resp: %s\n", socket.getInetAddress().toString(), socket.getPort(),
                        request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String process(String request) {
        return request;
    }
    public static void main(String[] args) throws IOException {
        EchoServer server = new EchoServer(9090);
        server.start();
    }
}
