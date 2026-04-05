class Solution {
    private int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] target = new int[n][m];
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                target[j][m-1-i] = matrix[i][j];
            }
        }
        return target;

    } 
    private boolean checkEqual(int[][] matrix, int[][] target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < m; j++) {
                if(target[i][j] != matrix[i][j]) return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] matrix, int[][] target) {
        if(checkEqual(matrix, target)) return true;
        int[][] ninety = rotate(matrix);
        if(checkEqual(target, ninety)) return true;
        int[][] oneEighty = rotate(ninety);
        if(checkEqual(target, oneEighty)) return true;
        int[][] twoSeventy = rotate(oneEighty);
        if(checkEqual(target, twoSeventy)) return true;
        return false;
    }
}