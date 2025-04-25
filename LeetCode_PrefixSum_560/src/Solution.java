/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,1);

        int sum = 0;
        int ret = 0;
        for(int x : nums){
            sum += x;
            ret += hash.getOrDefault(sum - k, 0);
            hash.put(sum,hash.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
