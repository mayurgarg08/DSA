class Solution {
    //  private int helper(int idx, int buy, int n, int[][] dp, int[] prices) {
    //      if(idx >= n) return 0;
    //      if(dp[idx][buy] != -1) return dp[idx][buy];
    //      int profit;
    //      if(buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx+1, 0, n, dp, prices), 0 + helper(idx+1, 1, n, dp, prices));
    //      } else {
    //         profit = Math.max(prices[idx]+ helper(idx+2, 1, n, dp, prices), 0 + helper(idx+1, 0, n, dp, prices));
    //      }
    //      return dp[idx][buy] = profit;
    //  }
      public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[n][0] = 0;
        dp[n+1][0] = 0;
        dp[n][1] = 0;
        dp[n+1][1] = 0;
        for(int idx = n-1; idx >= 0; idx--) {
            for(int buy = 0; buy < 2; buy++) {
               int profit;
               if(buy == 1) {
                  profit = Math.max(-prices[idx] + dp[idx+1][0], 0 + dp[idx+1][1]);
               } else {
                    profit = Math.max(prices[idx]+ dp[idx+2][1], 0 + dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }   
}