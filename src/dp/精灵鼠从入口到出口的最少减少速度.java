package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 精灵鼠从入口到出口的最少减少速度 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][]dp = new int[n][n];
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(",");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        dp[0][0] = map[0][0];
        for(int i=1;i<n;i++) {
            dp[0][i] = dp[0][i-1]+map[0][i];
            dp[i][0] = dp[i-1][0]+map[i][0];
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+map[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);

    }
}
