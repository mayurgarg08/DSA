class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1;
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                ans[top][i] = count;
                count++;
            }
            top++;
            for(int j = top; j <= bottom; j++) {
                ans[j][right] = count;
                count++;
            }
            right--;
            if(top <= bottom) {
                for(int k = right; k >= left; k--) {
                    ans[bottom][k] = count;
                    count++;
                }
                bottom--;
            }
            if(left <= right) {
                for(int l = bottom; l >= top; l--) {
                    ans[l][left] = count;
                    count++;
                }
                left++;
            }
        }
        return ans;
    }
}