package dp;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i = 1; i<= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
}
