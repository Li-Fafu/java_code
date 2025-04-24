/**
 * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。
 * 假定仅有一位同学缺席，请返回他的学号。
 */

/**
 * 解法：
 * 1、哈希
 * 2、直接遍历；
 * 3、位运算
 * 4、数学（高斯求和）
 */

//5、二分查找
class Solution {
    public int takeAttendance(int[] records) {
        int left = 0;
        int right = records.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(records[mid] == mid){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}