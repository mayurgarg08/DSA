class Solution {
    // private int helper(int i, int j, int[][] dp) {
    //    if(i == 0 && j == 0) return 1;
    //      if(i < 0 || j < 0) return 0;
    //      if(dp[i][j] != -1) return dp[i][j];
    //      int up = helper(i-1,j, dp);
    //      int left = helper(i, j-1, dp);
    //      return dp[i][j] = up + left;
    // }
    public int uniquePaths(int m, int n) {
         int[] prev = new int[n];
         for(int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) curr[j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0) up = prev[j];
                    if(j > 0) left = curr[j-1];
                    curr[j] = left + up;
                }
            }
            prev = curr;
         }
         return prev[n-1];
    }
}