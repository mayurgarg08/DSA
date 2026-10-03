class Solution {
    // private int  helper(int idx, int buy, int fee, int n, int[][] dp, int[] prices) {
    //     if(idx == n) return 0;
    //     int profit;
    //     if(dp[idx][buy] != -1) return dp[idx][buy];
    //     if(buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx+1, 0, fee, n, dp, prices), 0 + helper(idx+1, 1, fee, n, dp, prices));
    //     } else {
    //         profit = Math.max((prices[idx] - fee) + helper(idx+1, 1, fee, n, dp, prices), 0 + helper(idx+1, 0, fee, n, dp, prices));
    //     }
    //     return dp[idx][buy] = profit;
    // }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] next = new int[2];
         next[0] = 0;
         next[1] = 0;
         for(int idx = n-1; idx >= 0; idx--) {
            int[] curr = new int[2];
            for(int buy = 0; buy < 2; buy++) {
                int profit;
                if(buy == 1) {
                  profit = Math.max(-prices[idx] + next[0], 0 + next[1]);
                } else {
                  profit = Math.max((prices[idx] - fee) + next[1], 0 + next[0]);
                }
                curr[buy] = profit;      
            }
            next = curr;
         }
        return next[1];
    }
}