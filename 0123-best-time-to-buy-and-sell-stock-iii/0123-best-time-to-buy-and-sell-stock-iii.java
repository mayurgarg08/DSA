class Solution {
    private int helper(int idx, int buy, int cap, int n, int[][][] dp, int[] prices) {
        if(cap == 0) return 0;
        if(idx == n) return 0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        int profit;
        if(buy == 1) {
            profit = Math.max(-prices[idx] + helper(idx+1, 0, cap, n, dp, prices), 0 + helper(idx+1, 1, cap, n, dp, prices));
        } else {
            profit = Math.max(prices[idx] + helper(idx+1, 1, cap-1, n, dp, prices), 0 + helper(idx+1, 0, cap, n, dp, prices));
        }
        return dp[idx][buy][cap] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i = 0; i < n; i++) {
           for(int j = 0; j < 2; j++) {
              Arrays.fill(dp[i][j], -1);
           }
        }
        return helper(0, 1, 2, n, dp, prices);
    }    
}