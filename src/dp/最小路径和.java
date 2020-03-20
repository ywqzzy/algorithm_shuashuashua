package dp;

public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int line = grid.length;
        int row = grid[0].length;
        if (line < 1 || row < 1) return
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
}
