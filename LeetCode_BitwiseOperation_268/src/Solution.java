/**
 *给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class Solution {

    //哈希表
    public int missingNumber1(int[] nums) {
        int[] hash = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            hash[nums[i]] = 1;
        }
        for (int i = 0; i <= nums.length; i++) {
            if(hash[i] == 0){
                return i;
            }
        }
        return 0;
    }

    //高斯求和
    public int missingNumber2(int[] nums) {
        int sum1 = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum1 += i;
        }
        return sum1 - sum;
    }

    //位运算
    public int missingNumber3(int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret ^=nums[i] ^ i;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        Solution s = new Solution();
        System.out.println(s.missingNumber1(nums));
    }

}
