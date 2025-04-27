/**
 * https://leetcode.cn/problems/matrix-block-sum/description/
 */

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int xlen = mat.length;
        int ylen = mat[0].length;
        int[][] ret = new int[xlen][ylen];

        int[][] dp = new int[xlen + 1][ylen + 1];
        //初始化dp表
        for (int i = 1; i <= xlen; i++) {
            for (int j = 1; j <= ylen; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + mat[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }
        //使用dp表
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                int x1 = Math.max(0,i-k) + 1;
                int y1 = Math.max(0,j-k) + 1;
                int x2 = Math.min(xlen-1,i+k) + 1;
                int y2 = Math.min(ylen-1,j+k) + 1;
                ret[i][j] = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1 - 1][y1-1];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ret = new int[3][3];
        Solution s = new Solution();
        ret = s.matrixBlockSum(mat, 1);
        System.out.println(123);
    }
}
