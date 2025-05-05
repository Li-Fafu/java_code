import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cost = new int[n+1];
        for(int i = 0; i < n; i++){
            cost[i] = in.nextInt();
        }
        int[] dp = new int[n+1];
        for(int i = 2; i < n+1; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        System.out.println(dp[n]);
    }
}