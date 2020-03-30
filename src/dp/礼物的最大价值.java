package dp;

public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        if(grid == null) return 0;
        if(grid.length == 0) return 0;
        if(grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0]+ dp[i-1][0] ;
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1] ;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
