class Solution {
    public List<List<String>> solveNQueens(int n) {
       char[][] board = new char[n][n];
       for(int i = 0; i < n; i++) {
        Arrays.fill(board[i], '.');
       }
       List<List<String>> ans = new ArrayList<>();
       boolean[] col = new boolean[n];
       boolean[] diag1 = new boolean[2*n];
       boolean[] diag2 = new boolean[2*n];
       solve(n, board, ans, col, diag1, diag2, 0);
       return ans; 
    } 
    private void solve(int n, char[][] board, List<List<String>> ans, boolean[] col, boolean[] diag1, boolean[] diag2, int row) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i< n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int c = 0; c < n; c++) {
           if(col[c] || diag1[row - c + n] || diag2[row + c]) continue;

            board[row][c] = 'Q';
            col[c] = true;
            diag1[row-c+n] = true;
            diag2[row+c] = true;

            solve(n, board, ans, col, diag1, diag2, row+1);

            board[row][c] = '.';
            col[c] = false;
            diag1[row-c+n] = false;
            diag2[row+c] = false;
        }
    }
}