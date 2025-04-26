/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();//放的是Sum 和下标
        hash.put(0,-1);//默认有一个前缀和 0的下标为 -1

        int sum = 0;
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] ==0 ? -1 : 1);
            if(hash.containsKey(sum)){
                ret = Math.max(ret, i - hash.get(sum));
            }else{
                hash.put(sum, i);
            }
        }
        return ret;
    }
}
