class Solution {
    private boolean helper(int i, int j, int n, int m, int index, String word, char[][] board) {
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= n || j >= m) return false;

        if(board[i][j] != word.charAt(index)) return false;
        char ch = board[i][j];
        board[i][j] = '#';
        boolean found = helper(i+1, j, n, m, index+1, word, board) || 
                        helper(i-1, j, n, m, index+1, word, board) || helper(i, j+1, n, m, index+1, word, board) || helper(i, j-1, n, m, index+1, word, board);
        board[i][j] = ch;
        return found;
    }
    public boolean exist(char[][] board, String word) {
         int n = board.length;
         int m = board[0].length;
         for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
              if(helper(i, j, n, m, 0, word, board) == true) {
                return true;
              } 
            }
         }
         return false;
    }
}