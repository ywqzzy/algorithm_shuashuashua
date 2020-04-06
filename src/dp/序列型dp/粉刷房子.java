package dp.序列型dp;

public class 粉刷房子 {
    public int minCost(int[][] c) {
        if(c.length == 0) return 0;
        int[][] dp = new int[c.length+1][3];
        dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 0;
        for(int i=1;i<=c.length;i++)  {
            for(int j=0;j<3;j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0;k<3;k++) {
                    if(k!=j) {
                        dp[i][j]=Math.max(dp[i][j], dp[i-1][k]);
                    }
                }
                dp[i][j] += c[i-1][j];
            }
        }
        return Math.min(Math.min(dp[c.length][0], dp[c.length][1]), dp[c.length][2]);
    }
}
