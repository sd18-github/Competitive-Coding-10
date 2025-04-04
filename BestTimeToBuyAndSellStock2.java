/*
 * TC: O(n)
 * SC: O(1)
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sell, buy;
        sell = buy = 0;
        for(int i = n - 1; i >= 0; i--) {
            int temp = sell;
            // recurrence relation is f(sell) = max(p + buy, sell); f(buy) = max(p + sell, buy)
            sell = Math.max(prices[i] + buy, sell);
            buy = Math.max(-prices[i] + temp, buy);
        }

        return buy;
    }
}
