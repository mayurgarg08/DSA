class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                int val = Math.abs(i-start);
                mini = Math.min(mini, val);
            }
        }
        return mini;
    }
}