/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class Solution {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        for(int i = 0; i < n + 1; i++){
            int k = 0;
            int tem = i;
            while(tem > 0){
                tem &= (tem-1);
                k++;
            }
            ret[i] =k ;
        }
        return ret;
    }
}
