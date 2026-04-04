class Solution {
    private boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i*i <= num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int num1 = nums[i][i];
            int num2 = nums[i][n-1-i];

            if(isPrime(num1)) maxi = Math.max(maxi, num1);
            if(isPrime(num2)) maxi = Math.max(maxi, num2);
        }
        return maxi == Integer.MIN_VALUE? 0: maxi;
    }
}