/***
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题
 */

//解法一： 堆排序

//解法二：快排
import java.util.Random;

public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        return qsort(nums, 0, nums.length - 1, k);
    }

    private int qsort(int[] nums, int l, int r, int k) {
        int left = l - 1;
        int right = r + 1;
        int i = l;
        int key = nums[new Random().nextInt(r - l + 1) + l];
        while(i < right){
            if(nums[i] < key) {
                int temp = nums[i];
                nums[i++] = nums[++left];
                nums[left] = temp;
            } else if(nums[i] == key) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[--right];
                nums[right] = temp;
            }
        }

        int rightInterval = r - right + 1;
        int middleInterval = right - left - 1;
        if( rightInterval >= k){
            return qsort(nums,right,r,k);
        } else if(rightInterval + middleInterval >= k) {
            return key;
        } else {
            return qsort(nums, l, left, k - rightInterval - middleInterval);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[0];
    }
}
