/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] f = new int[n]; //前缀和数组
        int[] g = new int[n]; //后缀和数组
        f[0] = 1;
        g[n - 1] = 1;
        for(int i = 1; i < n; i++){
            f[i] = f[i-1] * nums[i-1];
        }
        for(int i = n-2; i>=0; i--){
            g[i] = g[i+1] * nums[i+1];
        }
        int[] ret = new int[n];
        for(int i = 0; i < n; i++){
            ret[i] = f[i] * g[i];
        }
        return ret;
    }
}
