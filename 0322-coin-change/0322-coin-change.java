class Solution {
    private int helper(int idx, int amount, int[] coins, int[][] dp) {
        if(amount == 0) return 0;
        if(idx == 0) {
            if(amount % coins[idx] == 0) {
                return amount/coins[idx];
            }
            return Integer.MAX_VALUE;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notTake = helper(idx-1, amount, coins, dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) {
            int result = helper(idx, amount - coins[idx], coins, dp);

            if(result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        } 
        return dp[idx][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
          if(amount == 0) return 0;
          int n = coins.length;
          int[][] dp = new int[n][amount+1];
          for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
          }
          int ans = helper(n-1, amount, coins, dp);
          return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}