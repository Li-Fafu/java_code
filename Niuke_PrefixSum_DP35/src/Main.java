/**
 * https://www.nowcoder.com/practice/99eb8040d116414ea3296467ce81cbbc?tpId=230&tqId=2023819&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[][] arr = new int [n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m;j++){
                arr[i][j] = in.nextInt();
            }
        }
        long[][] dp = new long [n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m;j++){
                dp[i][j] = dp[i -1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }


        while (q-- > 0) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            long ret = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
            System.out.println(ret);
        }
    }
}
