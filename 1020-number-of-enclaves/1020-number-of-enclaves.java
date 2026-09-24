class Solution {
    private void dfs(int i, int j, int[][] vis, int[][] grid, int n, int m) {
        vis[i][j] = 1;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++) {
            int drow = di[k] + i;
            int dcol = dj[k] + j;

            if(drow >= 0 && drow < n && dcol >= 0 && dcol < m && vis[drow][dcol] == 0 && grid[drow][dcol] == 1) {
                dfs(drow, dcol, vis, grid, n, m);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, vis, grid, n, m);
            }
            if(grid[i][m-1] == 1 && vis[i][m-1] == 0) {
                dfs(i, m-1, vis, grid, n, m);
            }
        }
        for(int j = 0; j < m; j++) {
            if(grid[0][j] == 1 && vis[0][j] == 0) {
                dfs(0, j, vis, grid, n, m);
            }
            if(grid[n-1][j] == 1 && vis[n-1][j] == 0) {
                dfs(n-1, j, vis, grid, n, m);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}