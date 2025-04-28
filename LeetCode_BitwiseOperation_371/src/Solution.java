/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 -，计算并返回两整数之和。
 */
public class Solution {
    public int getSum(int a, int b) {

        while(b != 0){
            int tem = a ^ b;
            int temp = (a & b) << 1;
            a = tem;
            b = temp;
        }
        return a;
    }
}
