class Solution {
    private int  helper(int idx, int amount, int[] coins, int[][] dp) {
         if(idx == 0) {
            if(amount % coins[idx] == 0) return 1;
            return 0;
         }
         if(dp[idx][amount] != -1) return dp[idx][amount];
         int notTake = helper(idx-1, amount, coins, dp);
         int take = 0;
         if(coins[idx] <= amount) take = helper(idx, amount-coins[idx], coins, dp);
         return dp[idx][amount] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n-1, amount, coins, dp);
    }
}