class Solution {
    private void dfs(int i, int j, char[][] board, int[][] vis, int n, int m) {
         vis[i][j] = 1;
         int[] dr = {-1, 0, 1, 0};
         int[] dc = {0, 1, 0, -1};

         for(int k = 0; k < 4; k++) {
            int drow = dr[k] + i;
            int dcol = dc[k] + j;

            if(drow >= 0 && drow < n && dcol < m && dcol >= 0 && vis[drow][dcol] == 0 && board[drow][dcol] == 'O') {
                dfs(drow, dcol, board, vis, n, m);
            }
         }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m]; 
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board, vis, n, m);
            }
            if(board[i][m-1] == 'O') {
                dfs(i, m-1, board, vis, n, m);
            }
        }
        for(int j = 0; j < m; j++) {
            if(board[0][j] == 'O') {
                dfs(0, j, board, vis, n, m);
            }
            if(board[n-1][j] == 'O') {
                dfs(n-1, j, board, vis, n, m);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
} 