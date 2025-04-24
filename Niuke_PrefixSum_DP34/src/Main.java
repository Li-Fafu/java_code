import java.util.Scanner;

/**
 * 给定一个长度为n的数组a1,a2,....an
 * 接下来有q次查询, 每次查询有两个参数l, r.对于每个询问, 请输出al+a(l+1)+....+ar
 * 输入描述：
 * 第一行包含两个整数n和q.
 * 第二行包含n个整数, 表示a1,a2,....an
 * 接下来q行,每行包含两个整数
 * 输出描述：输出q行,每行代表一次查询的结果.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        long[] dp = new long[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i-1] + arr[i-1];
        }

        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(dp[r] - dp[l-1]);

        }
    }
}
