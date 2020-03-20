package 买卖股票系列;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int mx = 0;
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < low) low = prices[i];
            mx = Math.max(mx, prices[i] - low);
        }
        return mx;
    }
}
