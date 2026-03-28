class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0) prev[i] = i/coins[0];
            else prev[i] = (int)1e9;
        }
        for(int idx = 1; idx < n; idx++) {
            int[] curr = new int[amount+1];
            for(int t = 0; t <= amount; t++) {
                    int notTake = prev[t];
                    int take = Integer.MAX_VALUE;
                    if(coins[idx] <= t) take = 1 + curr[t-coins[idx]];
                    curr[t] =  Math.min(take, notTake);
            }
            prev = curr;
        }
        return prev[amount] >= (int)1e9? -1: prev[amount];
    }
    // private int helper(int idx, int[] coins, int[][] dp, int amount) {
    //     if(idx == 0) {
    //         if(amount % coins[idx] == 0) return amount/coins[idx];
    //         else return (int)1e9;
    //     }
    //     if(dp[idx][amount] != -1) return dp[idx][amount];
    //     int notTake = helper(idx-1, coins, dp, amount);
    //     int take = Integer.MAX_VALUE;
    //     if(coins[idx] <= amount) take = 1 + helper(idx, coins, dp, amount-coins[idx]);
    //     return dp[idx][amount] =  Math.min(take, notTake);
    // }
}