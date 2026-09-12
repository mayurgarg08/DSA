class Solution {
    private boolean isSafe(char[][] board, int row, int col, int n) {
        int dupRow = row;
        int dupCol = col;
        while(row >= 0) {
            if(board[row][col] == 'Q') return false;
            row--;
        }
        row = dupRow;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false;
            else {
                row--;
                col--;
            }
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
    private void solve(int row, char[][] board, List<List<String>> ans, int n) {
        if(row == n) {
           List<String> temp =new ArrayList<>();
           for(int i = 0; i < n; i++) {
             temp.add(new String(board[i]));
           } 
           ans.add(new ArrayList<>(temp));
           return;
        }
        for(int col = 0; col < n; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(row+1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> ans = new ArrayList<>();
      char[][] board = new char[n][n];
      for(int i = 0; i < n; i++) {
        Arrays.fill(board[i], '.');
      }
      solve(0, board, ans, n);
      return ans;
    } 
}