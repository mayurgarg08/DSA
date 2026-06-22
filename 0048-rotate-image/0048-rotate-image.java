class Solution {
    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    private void reverse(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        while(low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                swap(matrix, i, j);
            }
        }
        for(int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }
}