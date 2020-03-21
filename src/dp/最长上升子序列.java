package dp;

public class 最长上升子序列 {
    // O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int res = 0;
        for(int num: nums) {
            int i = 0,j=res;
            while(i < j) {
                int mid = (i + j)/2;
                if(lis[mid] < num) i = mid + 1;
                else j = mid;
            }
            lis[i] = num;
            if(res == j) res++;
        }
        return res;
    }


    // O(n^2)
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[j], dp[i]);
            }
            dp[i]++;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
