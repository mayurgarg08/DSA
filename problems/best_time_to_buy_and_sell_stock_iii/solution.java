class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int profit;
        for(int idx = n-1; idx >= 0; idx--) {
            int[][] curr = new int[2][3];
            for(int buy = 0; buy < 2; buy++) {
                for(int cap = 1; cap < 3; cap++) {
                    if(buy == 1) {
                    profit = Math.max(-prices[idx] + after[0][cap], 0 + after[1][cap]);
                    } else {
                    profit = Math.max(prices[idx] + after[1][cap-1], 0 + after[0][cap]);
                    }
                    curr[buy][cap] = profit;
                }
            }
              after = curr;
        }
       return after[1][2];
    }
    // private int helper(int idx, int buy, int[] prices, int cap, int[][][] dp) {
    //     if(idx == prices.length) return 0;
    //     if(cap == 0) return 0;
    //     if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
    //     int profit;
     
    // }
}