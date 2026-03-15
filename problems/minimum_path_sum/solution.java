class Solution {

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        return dfs(grid, 0, 0, dp);
    }

    private int dfs(int[][] grid, int i, int j, int[][] dp) {

        if(i >= grid.length || j >= grid[0].length)
            return Integer.MAX_VALUE;

        if(i == grid.length-1 && j == grid[0].length-1)
            return grid[i][j];

        if(dp[i][j] != 0)
            return dp[i][j];

        int right = dfs(grid, i, j+1, dp);
        int down  = dfs(grid, i+1, j, dp);

        dp[i][j] = grid[i][j] + Math.min(right, down);

        return dp[i][j];
    }
}