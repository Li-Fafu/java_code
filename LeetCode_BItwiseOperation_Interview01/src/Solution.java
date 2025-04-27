/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 限制：
 *
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 */
public class Solution {
    public boolean isUnique(String astr) {
        if(astr.length() > 26){
            return false;
        }
        int bitmap = 0;
        for(int i = 0; i < astr.length(); i++){
            int x = astr.charAt(i) - 'a';
            if(((bitmap >> x) & 1) == 1){
                return false;
            }
            bitmap |= (1 << x);
        }
        return true;
    }
}
