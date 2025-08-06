class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        if(nums.length == 2) {
            return nums[1]-nums[0];
        }
        int maxDiff = 0;

        for(int i = 1; i<nums.length-1; i++) {
            int currDiff = 0;
            int diff1 = nums[i]-nums[i-1];
            int diff2 = nums[i+1]-nums[i];
            currDiff = Math.max(diff1, diff2);
            maxDiff = Math.max(maxDiff, currDiff);
        }
        return maxDiff;
    }
}