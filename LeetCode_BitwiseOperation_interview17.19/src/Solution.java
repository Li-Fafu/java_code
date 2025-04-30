/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 */
public class Solution {
    public int[] missingTwo(int[] nums) {
        int temp = 0;
        for(int x : nums){
            temp ^= x;
        }
        for(int i = 1; i <= nums.length + 2; i++){
            temp ^= i;
        }

        int k = 0;
        while(true){
            if(((temp >> k) & 1) == 1){
                break;
            }else{
                k++;
            }
        }

        int[] ret = new int[2];
        for(int x :nums){
            if(((x>>k) & 1) == 1){
                ret[0] ^= x;
            }else{
                ret[1] ^= x;
            }
        }
        for(int i = 1; i <= nums.length + 2; i++ ){
            if(((i>>k) & 1) == 1){
                ret[0] ^= i;
            }else{
                ret[1] ^= i;
            }
        }
        return ret;
    }
}
