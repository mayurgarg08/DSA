class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        int MOD = 12345;

        int n = grid.length;
        int m = grid[0].length;

        int size = n * m;

        long[] arr = new long[size];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j] % MOD;
            }
        }

        long[] prefix = new long[size];
        long[] suffix = new long[size];

        prefix[0] = 1;

        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
        }

        suffix[size - 1] = 1;

        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD;
        }

        int[][] ans = new int[n][m];
        idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int)((prefix[idx] * suffix[idx]) % MOD);
                idx++;
            }
        }

        return ans;
    }
}