class Solution {
    private boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i*i <= n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i%2 == 0) {
                if(isPrime(nums[i])) continue;
                else {
                    int num = nums[i];
                    while(!isPrime(num)) {
                        count++;
                        num++;
                    }
                }
            } else {
                if(!isPrime(nums[i])) continue;
                else {
                    int num = nums[i];
                    while(isPrime(num)) {
                        count++;
                        num++;
                    }
                }
            }
        }
        return count;
    }
}