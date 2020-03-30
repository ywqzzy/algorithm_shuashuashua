package dp;

public class n个骰子的点数 {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6*n + 1];
        for(int i = 1; i <= 6; i++) dp[1][i] = 1;
        for(int i = 2; i <= n; i++) {
            for(int s = i; s <= 6*i; s++) {
                for(int d = 1; d <= 6; i++) {
                    if(s - d < i - 1) break;
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double total = Math.pow((double)6, (double)n);
        double[] res = new double[5*n + 1];
        for(int i = n; i <= 6*n; i++) res[i-n] = ((double)dp[n][i]) / total;
        return res;
    }
}
