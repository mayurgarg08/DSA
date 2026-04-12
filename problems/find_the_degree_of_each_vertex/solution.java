class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        int j = 0;
        for(int[] arr: matrix) {
            int count = 0;
            for(int i : arr) {
                count += i;
            }
            ans[j] = count;
            j++;
        }
        return ans;
    }
}