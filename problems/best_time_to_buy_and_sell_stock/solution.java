class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for(int i = 0; i< prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            int pro = prices[i] - min;
            profit = Math.max(pro, profit);
        }   
        return profit;
    }
}