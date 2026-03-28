class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1 || nums[i] == 2) {
                for(int j = i+1; j < n; j++) {
                    if(nums[i] == 1) {
                        if(nums[j] == 2) mini = Math.min(mini, Math.abs(i - j));
                    } else {
                        if(nums[j] == 1) mini = Math.min(mini, Math.abs(i - j));
                    }
                }
            }
        }
        return mini == Integer.MAX_VALUE? -1: mini;
    }
}