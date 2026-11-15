class Solution {
    private void dfs(int i, int j, int[][] vis, char[][] grid, int n, int m) {
        vis[i][j] = 1;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++) {
            int drow = i + dr[k];
            int dcol = j + dc[k];

            if(drow < n && drow >= 0 && dcol >= 0 && dcol < m && vis[drow][dcol] == 0 && grid[drow][dcol] == '1') {
                dfs(drow, dcol, vis, grid, n, m);
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
                    dfs(i, j, vis, grid, n, m);
                }   
            }
        }
        return count;
    }
}