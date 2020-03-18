import java.util.Scanner;
/*
 旅行商问题 TSP
 */
public class 毕业旅行问题 {

//    dp[i][j]，其中i是压缩的状态，，j表示第j个城市。dp[i][j]表示状态是i且当前所在的城市是j时最小代价。转移方程：
  //  dp[i|(1<<k)][k] = min(dp[i|(1<<k)][k], dp[i][j]+dis[j][k])
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;n = sc.nextInt();
        int [][]m = new int[30][30];
        int [][]dp = new int[1<<19][24];
        for(int i = 0;i<(1<<19);i++)
            for(int j = 0;j<n;j++) dp[i][j] = 0x3f3f3f3f;
        for(int i=0;i<n;i++)
            for (int j=0;j<n;j++) m[i][j]=sc.nextInt();
        dp[1][0] = 0;


        for(int i = 1;i< (1<<n)-1; i++) {
            for(int j = 0; j < n;j++) {
                if(((1<<j) & i)==0 || dp[i][j] == 0x3f3f3f3f) continue;
                for(int k = 0;k<n;k++) {
                    if(((1<<k) &i)!=0) continue;
                    dp[i|(1<<k)][k] = Math.min(dp[i|(1<<k)][k],dp[i][j]+m[j][k]);
                }
            }
        }
        int res = 0x3f3f3f3f;
        for(int i = 1;i<n;i++){
            res = Math.min(res,dp[(1<<n)-1][i] + m[i][0]);
        }
        System.out.println(res);
    }
}
