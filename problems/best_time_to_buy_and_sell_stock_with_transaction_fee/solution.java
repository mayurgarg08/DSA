class Solution {
    public int maxProfit(int[] prices, int fee) {
         int n = prices.length;
        int[] front = new int[2];
        front[0] = 0;
        front[1] = 0;
       for(int idx = n-1; idx >= 0; idx--) {
        int[] curr = new int[2];
        for(int buy = 0; buy < 2; buy++) {
            int profit;
             if(buy == 1) {
            profit = Math.max(-prices[idx] + front[0], 0 + front[1]);
            } else {
            profit = Math.max(prices[idx] - fee + front[1], 0 + front[0]);
            }
            curr[buy] = profit;
        }
         front = curr;
       } 
       return front[1];
    }
}