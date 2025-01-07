class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum = new long[nums.length];
        int ans = 0;
        long sum = 0;
        for(int i = 0; i< nums.length; i++) {
           sum += nums[i];
           prefixSum[i] = sum;
        }

        for(int i = 0; i< prefixSum.length-1; i++) {
            if(prefixSum[i] >= (prefixSum[prefixSum.length-1]-prefixSum[i])) {
                ans++;
            }
        }
        return ans;
    }
}