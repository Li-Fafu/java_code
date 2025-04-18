import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int len = 1;
        Set hashSet = new HashSet<Character>();
        hashSet.add(s.charAt(0));
        while(left < s.length() && right < s.length()){
            if(!hashSet.contains(s.charAt(right))){
                hashSet.add(s.charAt(right));
                len = Math.max(len, right-left+1);
                right++;
            }else{
                while(hashSet.contains(s.charAt(right))){
                    hashSet.remove(s.charAt(left++));
                }
            }
        }
        return len;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] schar = s.toCharArray();
        int left =0;
        int right;
        int max_count =1;
        int count=1;
        if(s.equals(" ")) return 1;
        if(s.length()==0)return 0;

        for(right=1;right<schar.length;right++){
            count=1;
            for(int i=left;i<right;i++){
                if(schar[i]==schar[right]){
                    left = i+1;
                    break;
                }
                else{
                    count++;
                }
            }
            max_count = Math.max(max_count,count);
        }return max_count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        //System.out.println(solution.lengthOfLongestSubstring(s));
        System.out.println(solution.lengthOfLongestSubstring2(s));
    }
}
