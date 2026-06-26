class Solution {
    private boolean isSafe(char[][] board, int row, int col, int n) {
        int dupRow = row;
        int dupCol = col;
        while(row >= 0) {
            if(board[row][col] == 'Q') return false;
            row--;
        }
        row = dupRow;
        col = dupCol;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
            
        }
        row = dupRow;
        col = dupCol;
        while(row >= 0 && col < n) {
            if(board[row][col] == 'Q') return false;
            row--;
            col++;
        }
        return true;
    }
    private void solve(int row, List<List<String>> ans, char[][] board, int n) {
        if(row == n) {
          List<String> temp = new ArrayList<>();
          for(int i = 0; i < n; i++) {
            temp.add(new String(board[i]));
          }
          ans.add(temp);
          return;
        }
        for(int col = 0; col < n; col++) {
            if(isSafe(board, row, col, n)) {
               board[row][col] = 'Q';
               solve(row+1, ans, board, n);
               board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, ans, board, n);
        return ans;
    } 
}