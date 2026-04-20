class Solution {
    private int maxElement(int[][] mat, int col) {
        int n = mat.length;
        int maxRow = 0;

        for(int i = 0; i < n; i++) {
            if(mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = m - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            int maxRow = maxElement(mat, mid);

            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < m ? mat[maxRow][mid + 1] : Integer.MIN_VALUE;

            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            } 
            else if(mat[maxRow][mid] < left) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}