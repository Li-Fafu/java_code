/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 字母异位词:字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次。
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        int[] Phash = new int[26];
        int Pkinds = p.length();
        for (char c : p.toCharArray()) {
            Phash[c - 'a']++;
        }

        int[] Shash = new int[26];
        int Skinds = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char in = s.charAt(right);
            Shash[in - 'a']++;
            if(Shash[in - 'a'] <= Phash[in - 'a']) {
                Skinds++;
            }

            if((right - left +1) > p.length()){
                char out = s.charAt(left++);
                if(Shash[out - 'a'] <= Phash[out - 'a']) {
                    Skinds--;
                }
                Shash[out - 'a']--;
            }
            if(Pkinds == Skinds){
                ret.add(left);
            }
            right++;
        }
        return ret;
    }
}