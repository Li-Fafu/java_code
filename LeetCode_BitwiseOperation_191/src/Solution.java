/**
 * 给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。
 */
public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        while(n > 0){
            n &= (n-1);
            ret++;
        }
        return ret;
    }
}
