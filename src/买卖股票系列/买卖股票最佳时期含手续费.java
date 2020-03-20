package 买卖股票系列;

public class 买卖股票最佳时期含手续费 {

    public int maxProfit(int[] prices, int fee) {
        int sell = 0, hold = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, hold + prices[i] - fee);
            hold = Math.max(hold, sell - prices[i]);
        }
        return Math.max(sell, hold);
    }

}
