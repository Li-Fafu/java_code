public class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=nums[i-1]*left[i-1];
        }
        int R=1;
        for(int i=n-1;i>=0;i--){
            left[i]*=R;
            R*=nums[i];
        }
        return left;
    }
}
