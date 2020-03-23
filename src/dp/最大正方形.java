package dp;

public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        if(matrix.length == 0) return 0;
        if(matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int mx = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    mx = Math.max(mx, dp[i][j]);
                }
            }
        }
        return mx * mx;
    }
}
