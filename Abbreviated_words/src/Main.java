import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char ch = in.next().charAt(0);
            if(ch >= 'a' && ch <= 'z'){
                System.out.print((char)(ch - 32));
            }else{
                System.out.print(ch);
            }
        }
    }
}