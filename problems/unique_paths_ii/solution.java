class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m][n];

        return dfs(obstacleGrid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int i, int j, Integer[][] dp) {

        if(i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
            return 0;

        if(i == grid.length-1 && j == grid[0].length-1)
            return 1;

        if(dp[i][j] != null)
            return dp[i][j];

        int right = dfs(grid, i, j+1, dp);
        int down  = dfs(grid, i+1, j, dp);

        dp[i][j] = right + down;

        return dp[i][j];
    }
}