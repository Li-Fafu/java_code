/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 */
public class Solution {
    int[] tem;
    public int[] sortArray(int[] nums) {
        tem = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        //int mid = left + (right - left)/2;
        int mid = (left + right)/2;
        
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        
        int curleft = left;
        int curright = mid + 1;
        int i = 0;
        while(curleft <= mid && curright <= right){
            tem[i++] = nums[curleft] <= nums[curright] ? nums[curleft++] : nums[curright++];
        }
        while(curleft <= mid) {
            tem[i++] = nums[curleft++];
        }
        while(curright <= right) {
            tem[i++] = nums[curright++];
        }
        for(int j = left; j <= right; j++) {
            nums[j] = tem[j - left];
        }
    }
}
