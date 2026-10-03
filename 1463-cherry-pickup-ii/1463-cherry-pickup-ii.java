class Solution {
    // private int helper(int row1, int col1, int row2, int col2, int n, int m, int[][][] dp, int[][] grid) {
    //     if(row1 < 0 || row1 >= n || col1 < 0 || col1 >= m || row2 < 0 || row2 >= n || col2 < 0 || col2 >= m) {
    //         return Integer.MIN_VALUE;
    //     }
    //     if(row1 == n-1 && row2 == n-1) {
    //         if(col1 == col2) return grid[row1][col1];
    //         return grid[n-1][col1] + grid[n-1][col2];
    //     }
    //     int cherries;

    //     if(col1 == col2) {
    //         cherries = grid[row1][col1];
    //     } else {
    //         cherries = grid[row1][col1] + grid[row2][col2];
    //     }
    //     if(dp[row1][col1][col2] != -1) return dp[row1][col1][col2];
    //     int max = Integer.MIN_VALUE;

    //     for(int d1 = -1; d1 <= 1; d1++) {
    //         for(int d2 = -1; d2 <= 1; d2++) {
    //             int next = helper(row1 + 1, col1 + d1, row2 + 1, col2 + d2, n, m, dp, grid);
    //             max = Math.max(max, next);
    //         }
    //     }
    //     return dp[row1][col1][col2] = cherries + max;
    // }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       int[][] next = new int[m][m];

        for(int col1 = 0; col1 < m; col1++) {
            for(int col2 = 0; col2 < m; col2++) {

                if(col1 == col2) {
                    next[col1][col2] = grid[n-1][col1];
                } else {
                    next[col1][col2] =
                        grid[n-1][col1] + grid[n-1][col2];
                }
            }
        }
        for(int row1 = n-2; row1 >= 0; row1--) {
             int[][] curr = new int[m][m];
            for(int col1 = 0; col1 < m; col1++) {
                for(int col2 = 0; col2 < m; col2++) {
                    int cherries;

                    if(col1 == col2) {
                       cherries = grid[row1][col1];
                    } else {
                       cherries = grid[row1][col1] + grid[row1][col2];
                    }

                    int max = Integer.MIN_VALUE;

                    for(int d1 = -1; d1 <= 1; d1++) {
                       for(int d2 = -1; d2 <= 1; d2++) {
                          int temp = Integer.MIN_VALUE;
                          if(col1 + d1 >= 0 && col1 + d1 < m && col2 + d2 >= 0 && col2 + d2 < m) {
                             temp = next[col1 + d1][col2 + d2];
                          } 
                          max = Math.max(max, temp);
                        }
                    }
                    curr[col1][col2] = cherries + max;
                }
            }
            next = curr;
        }
        return next[0][m-1];
    }
}