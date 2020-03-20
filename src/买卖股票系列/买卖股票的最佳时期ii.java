package 买卖股票系列;

public class 买卖股票的最佳时期ii {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i-1];
            if(temp > 0) res += temp;
        }
        return res;
    }

    public static void main(String[] args) {
        买卖股票的最佳时期ii main = new 买卖股票的最佳时期ii();

    }
}
