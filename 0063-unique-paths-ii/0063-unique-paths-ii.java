class Solution {
    // private int helper(int i, int j, int[][] dp, int[][] grid) {
    //     if(i == 0 && j == 0) return 1;
    //     if(i < 0 || j < 0) return 0;
    //     if(grid[i][j] == 1) return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int left = helper(i, j-1, dp, grid);
    //     int up = helper(i-1, j, dp, grid);
    //     return dp[i][j] = left + up;
    // }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        for(int i = 0; i  < n; i++) {
            int[] curr = new int[m];
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    curr[j] = 0;
                    continue;
                } 
                if(i == 0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }    
                int left = 0;
                int up = 0;
                if(j > 0) left = curr[j-1];
                if(i > 0) up = prev[j];
                curr[j] = left + up;
            }
            prev = curr;
        }
        return prev[m-1];
    }
}