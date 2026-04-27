class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;

        int peak = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[peak]) {
                peak = i;
            }
        }

        long ascSum = 0;
        for(int i = 0; i <= peak; i++) {
            ascSum += nums[i];
        }

        long descSum = 0;
        for(int i = peak; i < n; i++) {
            descSum += nums[i];
        }

        if(ascSum > descSum) return 0;
        if(ascSum < descSum) return 1;
        return -1;
    }
}