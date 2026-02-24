class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = (long)n * n;  
        
        long expectedSum = (N * (N + 1)) / 2;
        long expectedSquareSum = (N * (N + 1) * (2 * N + 1)) / 6;
        
        long actualSum = 0;
        long actualSquareSum = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                long val = grid[i][j];
                actualSum += val;
                actualSquareSum += val * val;
            }
        }
        
        long diff = actualSum - expectedSum;  
        long squareDiff = actualSquareSum - expectedSquareSum;
        long sumAB = squareDiff / diff;  
        long a = (diff + sumAB) / 2;
        long b = a - diff;
        
        return new int[]{(int)a, (int)b};
    }
}