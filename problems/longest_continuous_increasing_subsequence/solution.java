class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = 1;
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 1;
            }
        }
        return maxLen;
    }
}