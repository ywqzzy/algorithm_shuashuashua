package dp;

public class 最小路径和 {
    public int minPathSum1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int line = grid.length;
        int row = grid[0].length;
        if (line < 1 || row < 1) return 0;
        dp[0][0] = grid[0][0];
        for(int i = 1; i < line;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < row; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < line; i++) {
            for(int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[line][row];
    }

    // 滚动数组
    public int minPathSum(int[][] grid) {

        int line = grid.length;
        int row = grid[0].length;
        if (line < 1 || row < 1) return 0;
        int[][] dp = new int[2][row];
        int old, now = 0;
        for(int i = 0; i < line; i++) {
            old = now;
            now = 1 - now;
            for(int j = 0; j < row; j++) {
                if(i == 0 && j == 0) {
                    dp[now][j] = grid[i][j];
                    continue;
                }
                int tmp = Integer.MAX_VALUE;
                if(i > 0) tmp = Math.min(tmp, dp[old][j]);
                if(j > 0) tmp = Math.min(tmp, dp[now][j-1]);
                dp[now][j] = tmp + grid[i][j];
            }
        }
        return dp[now][row-1];
    }
}
