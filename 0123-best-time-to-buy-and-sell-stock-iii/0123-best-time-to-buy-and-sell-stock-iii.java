class Solution {
    // private int helper(int idx, int buy, int cap, int n, int[][][] dp, int[] prices) {
    //     if(cap == 0) return 0;
    //     if(idx == n) return 0;
    //     if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
    //     int profit;
    //     if(buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx+1, 0, cap, n, dp, prices), 0 + helper(idx+1, 1, cap, n, dp, prices));
    //     } else {
    //         profit = Math.max(prices[idx] + helper(idx+1, 1, cap-1, n, dp, prices), 0 + helper(idx+1, 0, cap, n, dp, prices));
    //     }
    //     return dp[idx][buy][cap] = profit;
    // }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int buy = 0; buy < 2; buy++) {
            for(int cap = 0; cap < 3; cap++) {
                dp[n][buy][cap] = 0;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int buy = 0; buy < 2; buy++) {
                dp[i][buy][0] = 0;
            }
        }
        for(int idx = n-1; idx >= 0; idx--) {
            for(int buy = 0; buy < 2; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    int profit;
                    if(buy == 1) {
                       profit = Math.max(-prices[idx] + dp[idx+1][0][cap], 0 + dp[idx+1][1][cap]);
                    } else {
                       profit = Math.max(prices[idx] + dp[idx+1][1][cap-1], 0 + dp[idx+1][0][cap]);
                    }
                     dp[idx][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];
    }    
}