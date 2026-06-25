class Solution {
    private int helper(int idx, int[] coins, int amount, int[][] dp) {
        if(idx == 0) {
            if(amount % coins[0] == 0) return amount/coins[0];
            return (int)(1e9);
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notTake = helper(idx-1, coins, amount, dp);
        int take = Integer.MAX_VALUE;
        if(coins[idx] <= amount) take = 1 + helper(idx, coins, amount-coins[idx], dp);
        return dp[idx][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
          int n = coins.length;
          int[][] dp = new int[n][amount+1];
          for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
          int ans = helper(n-1, coins, amount, dp);
          if(ans >= (int)(1e9)) return -1;
          return ans; 
    }
}