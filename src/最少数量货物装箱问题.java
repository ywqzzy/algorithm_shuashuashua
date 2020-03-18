
import java.util.Scanner;

public class 最少数量货物装箱问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x =sc.nextInt();
        dpsolve(x);
    }
    static void dpsolve(int x) {
        int dp[] = new int[10001];
        if(x == 1||x==2||x==4) System.out.println(-1);
        dp[3]=1;dp[5]=1;dp[7]=1;dp[6]=2;
        dp[1]=10001;dp[2]=10001;dp[4]=10001;
        for(int i=8;i<=x;i++) {
            int t = Math.min(dp[i-3], Math.min(dp[i-5],dp[i-7]));
            dp[i] = t+1;
        }
        System.out.println(dp[x]);
    }
    static void greedysolve(int x) {
        if(x == 1||x==2||x==4) System.out.println(-1);
        else {
            int t = x%7;
            int ans = x/7;
            if(t==6 ||t==2||t==4) ans+=2;
            if(t==3||t==5||t==1) ans+=1;
            System.out.println(ans);
        }
    }
}
