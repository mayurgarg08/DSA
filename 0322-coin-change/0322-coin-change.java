class Solution {
    // private int helper(int idx, int amount, int[] coins, int[][] dp) {
    //     if(amount == 0) return 0;
    //     if(idx == 0) {
    //         if(amount % coins[idx] == 0) {
    //             return amount/coins[idx];
    //         }
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[idx][amount] != -1) return dp[idx][amount];
    //     int notTake = helper(idx-1, amount, coins, dp);
    //     int take = Integer.MAX_VALUE;
    //     if(coins[idx] <= amount) {
    //         int result = helper(idx, amount - coins[idx], coins, dp);

    //         if(result != Integer.MAX_VALUE) {
    //             take = 1 + result;
    //         }
    //     } 
    //     return dp[idx][amount] = Math.min(take, notTake);
    // }
    public int coinChange(int[] coins, int Amount) {
          if(Amount == 0) return 0;
          int n = coins.length;
          int[] prev = new int[Amount+1];
          for(int i = 0; i <= Amount; i++) {
               if(i % coins[0] == 0) {
                 prev[i] = i/coins[0];
               } else {
                  prev[i] = Integer.MAX_VALUE;
               }
          }
          for(int idx = 1; idx < n; idx++) {
            int[] curr = new int[Amount+1];
            for(int amount = 0; amount <= Amount; amount++) {
                int notTake = prev[amount];
                int take = Integer.MAX_VALUE;
               if(coins[idx] <= amount) {
                 int result = curr[amount-coins[idx]];

               if(result != Integer.MAX_VALUE) {
                 take = 1 + result;
                }
             } 
               curr[amount] = Math.min(take, notTake);
            }
            prev = curr;
          }
          int ans = prev[Amount];
          return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}