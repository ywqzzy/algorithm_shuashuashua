package dp;

public class 剪绳子 {
    public int cuttingRope(int n) {
        if(n < 2) return 0;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i-j)), dp[i]);
            }
        }
        return dp[n];
    }
}
