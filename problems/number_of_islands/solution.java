class Solution {
    
    private void dfs(int row, int col, int n, int m, char[][] grid) {
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        dfs(row-1, col, n, m, grid);
        dfs(row+1, col, n, m, grid);
        dfs(row, col-1, n, m, grid);
        dfs(row, col+1, n, m, grid);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i, j, n, m, grid);
                }
            }
        }
        return count;
    }
}