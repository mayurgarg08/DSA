class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        for(int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for(int j = 0; j < m; j++) {
                 if(grid[i][j] == 1) {
                    curr[j] = 0;
                    continue;
                 } 
                if(i == 0 && j == 0 && grid[i][j] != 1) {
                    curr[0] = 1;
                    continue;
                }
                int left = 0, up = 0;
                if(i > 0) up = prev[j];
                if(j > 0) left = curr[j-1];
                curr[j] = up+left; 
            }
            prev = curr;
        }
        return prev[m-1];
    }
    // private int helper(int row, int col, int[][] dp, int[][] grid) {
    //     if(row == 0 && col == 0 && grid[row][col] != 1) return 1;
    //     if(row < 0 || col < 0) return 0;
    //     if(grid[row][col] == 1) return 0;
    //     if(dp[row][col] != -1) return dp[row][col];
    //     int left = 0, up = 0;
    //     left = helper(row, col-1, dp, grid);
    //     up = helper(row-1, col, dp, grid);
    //     return dp[row][col] = left+up;
    // }
}