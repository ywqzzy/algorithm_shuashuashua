public class 不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[2][1] = 1;
        for(int k=1;k<=m;k++) dp[k][1] = 1;
        for(int i = 1; i <= m; i++) {
            if(i == 1) {
                for(int j = 1; j <=n;j++) dp[i][j] = 1;
            }
            for(int j = 1; j <= n; j++) {
                if(j==1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
