class Solution {
    public int search(int[] nums, int target) {
        //二分查找
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            //int mid = (right + left) / 2;

            //防止出现溢出
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}