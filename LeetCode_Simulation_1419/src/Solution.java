/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
 * 由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 *
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 *
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
 * 如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minNumberOfFrogs(String ss) {
        char[] croakOfFrogs = ss.toCharArray();
        String t = "croak";
        int n = t.length();
        int[] hash = new int[n];

        //创建哈希表 < 声音字符，顺序下标>
        Map<Character, Integer> index = new HashMap<>();
        //创建映射关系
        for (int i = 0; i < n; i++) {
            index.put(t.charAt(i),i);
        }

        //遍历输入字符串
        for(char ch : croakOfFrogs){
            if(ch == t.charAt(0)){
                //判断是否有蛙已经叫完
                if(hash[n-1] != 0){
                    hash[n - 1]--;
                }
                hash[0]++;
            } else {
                int i = index.get(ch);
                if(hash[i - 1] == 0){
                    return -1;
                }
                hash[i - 1]--;
                hash[i]++;
            }
        }

        for(int i = 0; i < n - 1; i++){
            if(hash[i] != 0){
                return -1;
            }
        }
        return hash[n - 1];
    }
}
