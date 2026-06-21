class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit = Integer.MIN_VALUE;
       int min = prices[0];

       for(int i = 1; i < prices.length; i++) {
          int profit = prices[i] - min;
          maxProfit = Math.max(maxProfit, profit);
          min = Math.min(min, prices[i]);
       }
       return maxProfit < 0? 0: maxProfit;
    }
}