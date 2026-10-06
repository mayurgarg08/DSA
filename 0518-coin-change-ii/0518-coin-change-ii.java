    class Solution {
//     private int  helper(int idx, int amount, int[] coins, int[][] dp) {
//          if(idx == 0) {
//             if(amount % coins[idx] == 0) return 1;
//             return 0;
//          }
//          if(dp[idx][amount] != -1) return dp[idx][amount];
//          int notTake = helper(idx-1, amount, coins, dp);
//          int take = 0;
//          if(coins[idx] <= amount) take = helper(idx, amount-coins[idx], coins, dp);
//          return dp[idx][amount] = take + notTake;
//     }
    public int change(int Amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[Amount+1];
        for(int i = 0; i <= Amount; i++) {
            if(i % coins[0] == 0) prev[i] = 1;
            else prev[i] = 0;
        }
        for(int idx = 1; idx < n; idx++) {
            int[] curr = new int[Amount+1];
            for(int amount = 0; amount <= Amount; amount++) {
                int notTake = prev[amount];
                int take = 0;
                if(coins[idx] <= amount) take = curr[amount-coins[idx]];
                curr[amount] = take + notTake;
            }
            prev = curr;
        }
        return prev[Amount];
    }
}