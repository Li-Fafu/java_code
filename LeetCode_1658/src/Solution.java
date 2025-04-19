class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int k : nums){
            sum += k;
        }
        int right = 0;
        int left = 0;
        int ret = -1;
        int target = sum - x;

        int localSum = 0;
        while(right < nums.length){
            localSum += nums[right];
            while(localSum > target && left < nums.length){
                localSum -= nums[left++];
            }
            if(localSum == target){
                ret = Math.max( ret, right - left + 1);
            }
            right++;
        }
        if(ret == -1){
            return ret;
        }
        return nums.length - ret;
    }
}


















