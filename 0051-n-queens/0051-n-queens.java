class Solution {
    private boolean isSafe(int row, int col, char[][] board, int n) {
        int dupRow = row;
        int dupCol = col;
        for(int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') return false;
            else if(board[row][i] == 'Q') return false;
        }
        while(row >= 0 && col < n) {
            if(board[row][col] == 'Q') return false;
            row--;
            col++;
        }
        row = dupRow;
        col = dupCol;
        while(col >= 0 && row >= 0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(row < n && col < n) {
            if(board[row][col] == 'Q') return false;
            row++;
            col++;
        }
        row = dupRow;
        col = dupCol;
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    private void helper(int row, char[][] board, int n, List<List<String>> ans) {
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }
        for(int col = 0; col < n; col++) {
            if(isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                helper(row+1, board, n, ans);
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
       helper(0, board, n, ans);
       return ans;
    } 
}