package dp;

public class 乘积最大子序列 {
    /*
    maxDP[i + 1] = max(maxDP[i] * A[i + 1], A[i + 1],minDP[i] * A[i + 1])
    minDP[i + 1] = min(minDP[i] * A[i + 1], A[i + 1],maxDP[i] * A[i + 1])
    dp[i + 1] = max(dp[i], maxDP[i + 1])

     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int tmin = 1, tmax = 1;
        for(int num: nums) {
            if(num < 0) {
                int temp = tmax;
                tmax = tmin;
                tmin = temp;
            }
            tmax = Math.max(tmax * num, num);
            tmin = Math.min(tmin * num, num);
            res = Math.max(tmax, res);
        }
        return res;
    }
}
