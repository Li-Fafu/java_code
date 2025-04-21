/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        int[] hash1 = new int[128];
        int m = t.length();
        for(int i = 0; i < m; i++){
            hash1[t.charAt(i)]++;
        }

        String ret = new String();
        int res = 0;
        int len = 128;


        int left = 0;
        int right = 0;
        int count = 0;
        int[] hash2 = new int[128];
        while(right < s.length()){
            char in = s.charAt(right);
            hash2[in]++;
            if(hash2[in] <= hash1[in]){
                count++;
            }

            while(count == m){

                if(len > right - left + 1){
                    res = left;
                    len = Math.min(len, right - left + 1);
                }

                char out = s.charAt(left);
                if(hash2[out]-- <= hash1[out]){
                    count--;
                }
                left++;
            }
            right++;
        }
        return len == 128 ? "" : s.substring(res, res + len);
    }

    public static void main(String[] args) {
        String s = "a", t = "b";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}