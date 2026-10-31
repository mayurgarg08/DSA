class Solution {
    private boolean helper(int i, int j, char[][] board, int idx, String word, int n, int m) {
        if(idx == word.length()) {
            return true;
        }
        if(i >= n || i < 0 || j >= m || j < 0) return false;
        if(board[i][j] != word.charAt(idx)) return false;
        
        char ch = board[i][j];
        board[i][j] = '#';

        boolean found = helper(i+1, j, board, idx+1, word, n, m) || helper(i-1, j, board, idx+1, word, n, m) || helper(i, j+1, board, idx+1, word, n, m) || helper(i, j-1, board, idx+1, word, n, m);

        board[i][j] = ch;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(helper(i, j, board, 0, word, n, m) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}