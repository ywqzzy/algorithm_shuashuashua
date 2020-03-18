import java.util.Scanner;

public class 玫瑰花 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int mod = 772235;
        int [][]dp = new int[n+2][k+2];
        dp[1][1] = 1;
        for(int i = 2;i<=n;i++) {
            for(int j = 1;j<=k;j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod * j % mod;
            }
        }
        System.out.println(dp[n][k]);
    }
}
