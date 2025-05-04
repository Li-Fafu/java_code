import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qsort(nums, 0, nums.length - 1, k);
    }

    public int qsort(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }

        // 1.按照随机选择的基准元素，将数组分三块
        int key = nums[new Random().nextInt(r - l + 1) + l];
        int left = l - 1;
        int right = r + 1;
        int i = l;
        while (i < right) {
            if (nums[i] < key) {
                swap(nums, ++left, i++);
            }
            else if (nums[i] == key) {
                i++;
            }
            else {
                swap(nums, --right, i);
            }
        }

        // 2.分情况讨论
        int c = r - right + 1;
        int b = right - left - 1;
        if (c >= k) {
            return qsort(nums, right, r, k);
        }
        else if (c + b >= k) {
            return key;
        }
        else {
            return qsort(nums, l, left, k - b - c);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(arr,1));
    }
}
