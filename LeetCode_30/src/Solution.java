/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。

 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> hash1 = new HashMap<>();
        for(String str: words){
            hash1.put(str, hash1.getOrDefault(str, 0) + 1);
        }

        int len = words[0].length();
        int m = words.length;
        for(int i = 0; i < len; i++){
            Map<String, Integer> hash2 = new HashMap<>();
//            int left = i;
//            int right = i;
//            int count = 0;
//            while(right + len < s.length()){

            for(int left = i, right = i,count = 0; right + len <= s.length(); right += len){
                String in = s.substring(right, right + len);
                hash2.put(in, hash2.getOrDefault(in, 0) + 1);
                if(hash2.get(in) <= hash1.getOrDefault(in,0)){
                    count++;
                }

                if(right - left + 1 > m*len){
                    String out = s.substring(left, left + len);
                    if(hash2.get(out) <= hash1.getOrDefault(out,0)){
                        count--;
                    }
                    hash2.put(out, hash2.get(out) - 1);
                    left += len;
                }
                if(count == m){
                    res.add(left);
                }
                //right += len;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[] {"foo", "bar"};
        Solution solution = new Solution();
        List<Integer> substring = solution.findSubstring(s, words);
        System.out.println(substring.toString());
    }
}