package easy;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description"/>Problem Description</a>
 */
public class BestTimeStockBuySell {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int max = 0;
        int left = 0;
        int right = 1;

        while(right < prices.length) {
            if (prices[right] > prices[left]) {
                int stockValue = prices[right] - prices[left];
                if(stockValue > max) {
                    max = stockValue;
                }
            }
            else {
                left=right;
            }
            right++;
        }

        System.out.println(max);
    }
}
