class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int r =0, l = 0;
        int n = nums.length;
        int zeros = 0;
        while(r<n) {
            if(nums[r] == 0) zeros++;
            if(zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            } 
            int len = r-l+1;
            maxOnes = Math.max(maxOnes, len);
            r++;
        }
        return maxOnes;
    }
}