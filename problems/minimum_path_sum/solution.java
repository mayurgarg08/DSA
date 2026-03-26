class Solution {
    public int minPathSum(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int[] prev = new int[m];
       for(int row = 0; row < n; row++) {
        int[] curr = new int[m];
        for(int col = 0; col < m; col++) {
            if(row == 0 && col == 0) {
                curr[col] = grid[0][0];
                continue;
            }
            int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
            if(col > 0) left = grid[row][col] + curr[col-1];
            if(row > 0) up = grid[row][col] + prev[col];
            curr[col] = Math.min(left, up); 
        }
        prev = curr;
       }
       return prev[m-1];
    }
    // private int helper(int row, int col, int[][] dp, int[][] grid) {
    //    if(row == 0 && col == 0) return grid[0][0];
    //    if(row < 0 || col < 0) return Integer.MAX_VALUE;
    //    if(dp[row][col] != -1) return dp[row][col];
    //    int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
    //    if(col > 0) left = grid[row][col] + helper(row, col-1, dp, grid);
    //    if(row > 0) up = grid[row][col] + helper(row-1, col, dp, grid);
    //    return dp[row][col] = Math.min(left, up); 
    // }
}