import java.util.Scanner;
public class 小Q的歌单{
    public static final int MOD = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k=sc.nextInt(),a=sc.nextInt(), x=sc.nextInt(),b=sc.nextInt(), y=sc.nextInt();
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i=0;i<x;i++)
            for(int j=k;j>=a;j--)
                dp[j]=(dp[j]+dp[j-a])%MOD;
        for(int i=0;i<y;i++)
            for(int j=k;j>=b;j--)
                dp[j]=(dp[j]+dp[j-b])%MOD;
        System.out.println(dp[k]);
    }
}