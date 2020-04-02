package dp;

public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int res = 0;
        int mx = nums[0];
        for(int num: nums) {
            if(res <= 0) res = num;
            else res += num;
            mx = Math.max(res, mx);
        }
        return mx;
    }
}
