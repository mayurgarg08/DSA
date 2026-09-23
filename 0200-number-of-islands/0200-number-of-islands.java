class Solution {
    private void dfs(int i, int j, int n, int m, int[][] vis, char[][] grid) {
        vis[i][j] = 1;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        for(int k = 0; k < 4; k++) {
            int drow = i + di[k];
            int dcol = j + dj[k];

            if(drow >= 0 && drow < n && dcol < m && dcol >= 0 && grid[drow][dcol] == '1' && vis[drow][dcol] == 0) {
                dfs(drow, dcol, n, m, vis, grid);
            }
        } 
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
              if(grid[i][j] == '1' && vis[i][j] == 0) {
                 count++;
                 dfs(i, j, n, m, vis, grid);
              }
            }
        }
        return count;
    }
}