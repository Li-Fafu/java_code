import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = 0;
        while(n < nums.length - 3){
            if(nums[n] > 0 && target < 0)break;
            int k = n+1;
            while(k < nums.length - 2){
                int left = k + 1;
                int right = nums.length-1;
                while(left < right){
                    long sum = (long)nums[left] + nums[right];
                    if(sum < (target - nums[n] - nums[k])){
                        left++;
                        while(left < right && nums[left] == nums[left-1]) left++;
                    }else if(sum > (target - nums[n] - nums[k])){
                        right--;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }else{
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[n],nums[k],nums[left],nums[right])));
                        left++;
                        while(left < right && nums[left] == nums[left-1]) left++;
                        right--;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }
                }
                k++;
                while(k < nums.length - 2 && nums[k] == nums[k-1]) k++;
            }
            n++;
            while(n < nums.length - 3 && nums[n] == nums[n-1]) n++;{}
        }
        return res;
    }
}














