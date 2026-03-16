class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++) {
            int[] row = new int[10];
            int[] col = new int[10];
            int[] box = new int[10];

            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if(row[num] == 1) return false;
                    row[num]++;
                }

                if(board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if(col[num] == 1) return false;
                    col[num]++;
                }

                int r = 3 * (i / 3) + j / 3;
                int c = 3 * (i % 3) + j % 3;

                if(board[r][c] != '.') {
                    int num = board[r][c] - '0';
                    if(box[num] == 1) return false;
                    box[num]++;
                }
            }
        }

        return true;
    }
}