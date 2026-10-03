class Solution {
    private int helper(int idx, int buy, int[][] dp, int[] prices) {
        if(idx == prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit;
        if(buy ==  1) {
            profit = Math.max(-prices[idx] + helper(idx+1, 0, dp, prices), 0 + helper(idx+1, 1, dp, prices));
        } else {
            profit = Math.max(prices[idx] + helper(idx+1, 1, dp, prices), 0 + helper(idx+1, 0, dp, prices));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return helper(0, 1, dp, prices);   
    }
}