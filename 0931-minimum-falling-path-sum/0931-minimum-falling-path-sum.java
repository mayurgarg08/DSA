class Solution {
    // private int helper(int i, int j, int[][] dp, int[][] matrix) {
    //     if(i < 0 || j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE;
    //     if(i == 0) return matrix[i][j];
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int left = helper(i-1, j-1, dp, matrix);
    //     int right = helper(i-1, j+1, dp, matrix);
    //     int mid = helper(i-1, j, dp, matrix);
    //     return dp[i][j] = matrix[i][j] + Math.min(left, Math.min(mid, right));
    // }
    public int minFallingPathSum(int[][] matrix) {
       int n = matrix.length;
       int m = matrix[0].length;
       int min = Integer.MAX_VALUE;
       int[][] dp = new int[n][m];
       for(int i = 0; i < n; i++) {
          for(int j = 0; j < m; j++) {
              if(i == 0) {
                dp[i][j] = matrix[i][j];
                continue;
              }
              int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
              if(i > 0 && j > 0) left = dp[i-1][j-1];
              if(i > 0 && j < m-1) right = dp[i-1][j+1];
              if(i > 0) mid = dp[i-1][j];
              dp[i][j] = matrix[i][j] + Math.min(left, Math.min(mid, right));
          }
       }       
       for(int i = 0; i < m; i++) min = Math.min(min, dp[n-1][i]);
       return min;
    }
}