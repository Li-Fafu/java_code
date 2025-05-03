/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 */

import java.util.Random;

public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if(l >= r ){
            return;
        }
        int key = nums[new Random().nextInt(r - l + 1) + l];
        int left = l - 1;
        int right = r + 1;
        int i = l;
        while(i < right){
            if( nums[i] < key){
                int temp = nums[i];
                nums[i++] = nums[++left];
                nums[left] = temp;
            } else if(nums[i] == key){
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[--right];
                nums[right] = temp;
            }
        }

        quickSort(nums,l, left);
        quickSort(nums,right, r);
    }
}