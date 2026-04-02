class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        int[][][] dp = new int[n][m][3];
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);      
            }
        }

        for(int neut = 0; neut <= 2; neut++) {
            if(coins[0][0] < 0 && neut > 0) dp[0][0][neut] = 0;
            else dp[0][0][neut] = coins[0][0]; 
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) continue;

                for(int neut = 0; neut <= 2; neut++) {
                     int left = Integer.MIN_VALUE;
                     int up = Integer.MIN_VALUE;
                     int left1 = Integer.MIN_VALUE;
                     int up1 = Integer.MIN_VALUE;

        if(coins[i][j] < 0 && neut > 0) {

            if(j-1 >= 0) left = dp[i][j-1][neut - 1];
            if(i-1 >= 0) up = dp[i-1][j][neut - 1];

            if(j-1 >= 0) left1 = coins[i][j] + dp[i][j-1][neut];
            if(i-1 >= 0) up1 = coins[i][j] + dp[i-1][j][neut];

            dp[i][j][neut] = Math.max(Math.max(left, up), Math.max(left1, up1));

        } else {
            if(j-1 >= 0) left = coins[i][j] + dp[i][j-1][neut];
            if(i-1 >= 0) up = coins[i][j] + dp[i-1][j][neut];

             dp[i][j][neut] = Math.max(left, up);
                } 
            }
        }
    }
    return dp[n-1][m-1][2];

    } 
    // private int helper(int i, int j, int[][] coins, int[][][] dp, int neut) {
    //     if(i == 0 && j == 0) {
    //         if(coins[0][0] < 0 && neut > 0) return 0; 
    //         return coins[0][0];
    //     }

    //     if(dp[i][j][neut] != -1) return dp[i][j][neut];

    //     int left = Integer.MIN_VALUE;
    //     int up = Integer.MIN_VALUE;
    //     int left1 = Integer.MIN_VALUE;
    //     int up1 = Integer.MIN_VALUE;

    //     if(coins[i][j] < 0 && neut > 0) {

    //         if(j-1 >= 0) left = helper(i, j-1, coins, dp, neut - 1);
    //         if(i-1 >= 0) up = helper(i-1, j, coins, dp, neut - 1);

    //         if(j-1 >= 0) left1 = coins[i][j] + helper(i, j-1, coins, dp, neut);
    //         if(i-1 >= 0) up1 = coins[i][j] + helper(i-1, j, coins, dp, neut);

    //         return Math.max(Math.max(left, up), Math.max(left1, up1));

    //     } else {
    //         if(j-1 >= 0) left = coins[i][j] + helper(i, j-1, coins, dp, neut);
    //         if(i-1 >= 0) up = coins[i][j] + helper(i-1, j, coins, dp, neut);

    //         return dp[i][j][neut] = Math.max(left, up);
    //     }
    // }
}
