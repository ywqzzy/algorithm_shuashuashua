package dp;

import java.util.Scanner;

public class 上台阶 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int []dp=new int[n+2];
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        for(int i=4;i<=n;i++) {
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        System.out.println(dp[n]);
    }
}
