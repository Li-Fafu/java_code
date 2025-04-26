/**
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
 *
 * 子数组 是数组中 连续 的部分。
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0%k, 1);//哈希表中存放的是余数
        int sum = 0;
        int ret = 0;

        for(int x : nums){
            sum += x;
            int i = (sum % k + k) % k;
            ret += hash.getOrDefault(i, 0);
            hash.put(i,hash.getOrDefault(i, 0) + 1);
        }
        return ret;
    }
}
