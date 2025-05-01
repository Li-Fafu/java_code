/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        //公差
        int d = 2 * numRows - 2;
        int n = s.length();

        StringBuilder ret = new StringBuilder();

        //处理首行
        for(int i = 0; i < n; i += d){
            ret.append(s.charAt(i));
        }

        //处理中间行
        for(int k = 1; k < numRows - 1; k++){
            for(int i = k, j = d - i; i < n || j < n; i +=d, j+=d){
                if(i < n){
                    ret.append(s.charAt(i));
                }
                if(j < n){
                    ret.append(s.charAt(j));
                }
            }
        }

        //处理尾行
        for(int i = numRows - 1; i < n; i += d){
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }
}
