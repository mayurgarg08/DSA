class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0) prev[i] = 1;
            else prev[i] = 0;
        }
        for(int idx = 1; idx < n; idx++) {
            int[] curr = new int[amount+1];
            for(int t = 0; t <= amount; t++) {
                    int notTake = prev[t];
                    int take = 0;
                    if(coins[idx] <= t) take = curr[t-coins[idx]];
                    curr[t] =  take + notTake;
            }
            prev = curr;
        }
        return prev[amount];
    }
    // private int helper(int idx, int[] coins, int[][] dp, int amount) {
    //        if(idx == 0) {
    //        if(amount % coins[idx] == 0) return 1;
    //        else return 0;
    //        }
    //        if(dp[idx][amount] != -1) return dp[idx][amount];
    //        int notTake = helper(idx-1, coins, dp, amount);
    //        int take = 0;
    //        if(coins[idx] <= amount) take = helper(idx, coins, dp, amount-coins[idx]);
    //        return dp[idx][amount] = take + notTake;
    //      }
}