package dp;

public class 最长上升子序列 {
    // O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;

        for(int i = 1; i < len; i++) {
            if(nums[i] > tail[end]) {
                end++;
                tail[end] = nums[i];
            } else {
                int left = 0, right = end;
                while(left < right) {
                    int mid = left + ((right - left) >>> 1);
                    if(tail[mid] < nums[i]) left = mid + 1;
                    else right = mid;
                }
                tail[left] = nums[i];
            }
        }
        return end + 1;
    }


    // O(n^2)  这个好理解
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
