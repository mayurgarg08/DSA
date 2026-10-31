class Solution {
    private boolean isPossible(int i, int j, int k, char[][] board) {
        for(int l = 0; l < 9; l++) {
            if(board[i][l]-'0' == k) return false;
            if(board[l][j]-'0' == k) return false;
            if(board[3 * (i/3) + l/3][3 * (j/3) + l%3]-'0' == k) return false;
        }
        return true;
    }
    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(int k = 1; k <= 9; k++) {
                        if(isPossible(i, j, k, board)) {
                            board[i][j] = (char)(k+'0');
                            if(solve(board) == true) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}