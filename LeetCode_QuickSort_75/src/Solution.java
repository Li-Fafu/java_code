/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int left = -1;
        int right = nums.length;
        while(i < right){
            if(nums[i] == 0){
                int temp = nums[++left];
                nums[left] = nums[i];
                nums[i] = temp;
                i++;
            } else if(nums[i] == 1){
                i++;
            } else {
                int temp = nums[--right];
                nums[right] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
