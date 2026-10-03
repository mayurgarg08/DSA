class Solution {
    // private int helper(int idx, int buy, int k, int n, int[][][] dp, int[] prices) {
    //     if(k == 0) return 0;
    //     if(idx == n) return 0;
    //     if(dp[idx][buy][k] != -1) return dp[idx][buy][k];
    //     int profit;
    //     if(buy == 1) {
    //         profit = Math.max(-prices[idx] + helper(idx+1, 0, k, n, dp, prices), 0 + helper(idx+1, 1, k, n, dp, prices));
    //     } else {
    //         profit = Math.max(prices[idx] + helper(idx+1, 1, k-1, n, dp, prices), 0 + helper(idx+1, 0, k, n, dp, prices));
    //     }
    //     return dp[idx][buy][k] = profit;
    // } 
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                dp[i][j][0] = 0;
            }
        }
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= k; j++) {
                dp[n][i][j] = 0;
            }
        }
        for(int idx = n-1; idx >= 0; idx--) {
            for(int j = 0; j < 2; j++) {
                for(int l = 1; l <= k; l++) {
                    int profit;
                    if(j == 1) {
                        profit = Math.max(-prices[idx] + dp[idx+1][0][l], 0 + dp[idx+1][1][l]);
                    } else {
                        profit = Math.max(prices[idx] + dp[idx+1][1][l-1], 0 + dp[idx+1][0][l]);
                    }
                    dp[idx][j][l] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
}