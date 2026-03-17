class Solution {
    public void solveSudoku(char[][] board) {
          int[][] row = new int[9][10];
          int[][] col = new int[9][10];
          int[][] box = new int[9][10];

          for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                   int num = board[i][j] - '0';
                   row[i][num] = col[j][num] = 1;
                   int boxIndex = (i/3)*3 + (j/3);
                   box[boxIndex][num] = 1;
                }
            }
          }
          solve(board, row, col, box);
    }
    private boolean solve(char[][] board, int[][] row, int[][] col, int[][] box) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(int num = 1; num <= 9; num++) {
                    int boxIndex = (i/3)*3+(j/3);
                    if(row[i][num] == 0 && col[j][num] == 0 && box[boxIndex][num] == 0) {
                        board[i][j] = (char)(num + '0');
                        row[i][num] = col[j][num] = box[boxIndex][num] = 1;
                        if(solve(board, row, col, box) == true) return true;

                        board[i][j] = '.';
                        row[i][num] = col[j][num] = box[boxIndex][num] = 0;
                    }
                }
                return false;
                }  

            }
        }
        return true;
    }
}