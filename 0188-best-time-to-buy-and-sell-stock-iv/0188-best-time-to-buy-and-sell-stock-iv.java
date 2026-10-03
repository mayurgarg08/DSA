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
        int[][] after = new int[2][k+1];
        int[][] curr = new int[2][k+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                curr[j][0] = 0;
            }
        }
        for(int i = 0; i < 2; i++) {
            for(int j = 1; j <= k; j++) {
                after[i][j] = 0;
            }
        }
        for(int idx = n-1; idx >= 0; idx--) {
            for(int j = 0; j < 2; j++) {
                for(int l = 1; l <= k; l++) {
                    int profit;
                    if(j == 1) {
                        profit = Math.max(-prices[idx] + after[0][l], 0 + after[1][l]);
                    } else {
                        profit = Math.max(prices[idx] + after[1][l-1], 0 + after[0][l]);
                    }
                    curr[j][l] = profit;
                }
            }
            after = curr;
        }
        return after[1][k];
    }
}