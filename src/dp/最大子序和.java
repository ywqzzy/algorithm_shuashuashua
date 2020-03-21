package dp;

public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res = 0;
        int mx = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(res > 0) res+=nums[i];
            else res = nums[i];
            mx = Math.max(mx, res);
        }
        return mx;
    }
}
