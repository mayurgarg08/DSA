class Solution {
    // private int helper(int idx, int[] coins, int amount, int[][] dp) {
    //     if(idx == 0) {
    //         if(amount % coins[0] == 0) return amount/coins[0];
    //         return (int)(1e9);
    //     }
    //     if(dp[idx][amount] != -1) return dp[idx][amount];
    //     int notTake = helper(idx-1, coins, amount, dp);
    //     int take = Integer.MAX_VALUE;
    //     if(coins[idx] <= amount) take = 1 + helper(idx, coins, amount-coins[idx], dp);
    //     return dp[idx][amount] = Math.min(take, notTake);
    // }
    public int coinChange(int[] coins, int amount) {
          int n = coins.length;
          int[][] dp = new int[n][amount+1];
          for(int target = 0; target <= amount; target++) {
            if(target % coins[0] == 0) dp[0][target] = target/coins[0];
            else dp[0][target] = (int)(1e9);
          }
          for(int idx = 1; idx < n; idx++) {
            for(int target = 0; target <= amount; target++) {
                int notTake = dp[idx-1][target];
                int take = (int)1e9;
                if(coins[idx] <= target) take = 1 + dp[idx][target-coins[idx]];
                dp[idx][target] = Math.min(take, notTake);
            }
          }
          int ans = dp[n-1][amount];
          if(ans >= (int)(1e9)) return -1;
          return ans; 
    }
}