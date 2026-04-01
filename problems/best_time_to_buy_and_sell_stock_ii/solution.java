class Solution {
    public int maxProfit(int[] prices) {
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
            profit = Math.max(prices[idx] + front[1], 0 + front[0]);
            }
            curr[buy] = profit;
        }
         front = curr;
       } 
       return front[1];
    }
    // private int helper(int idx, int buy, int[][] dp, int[] prices) {
    //     if(idx == prices.length) return 0;
    //     if(dp[idx][buy] != -1) return dp[idx][buy];
    //     int profit;
    //     if(buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx+1, 0, dp, prices), 0 + helper(idx+1, 1, dp, prices));
    //     } else {
    //         profit = Math.max(prices[idx] + helper(idx+1, 1, dp, prices), 0 + helper(idx+1, 0, dp, prices));
    //     }
    //     return dp[idx][buy] = profit;
    //}
}