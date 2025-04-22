/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        //处理边界
        if (nums.length == 0) {
            return ret;
        }

        int left = 0;
        int right = nums.length - 1;

        //找到左端点
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //判断是否有结果
        if (nums[left] != target) {
            return ret;
        } else {
            ret[0] = left;
        }

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            //找右端点
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        ret[1] = left;
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        Solution solution = new Solution();
        int[] ret = solution.searchRange(nums, target);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
}