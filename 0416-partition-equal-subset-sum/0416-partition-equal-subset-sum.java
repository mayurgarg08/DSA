class Solution {
     public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[] next = new boolean[target+1];
        next[0] = true;
        for(int sum = 0; sum <= target; sum++) {
            if(sum == target) {
                next[sum] = true;
            } else {
                next[sum] = false;
            }
        }
        for(int idx = n-1; idx >= 0; idx--) {
            boolean[] curr = new boolean[target+1];
            for(int sum = 0; sum <= target; sum++) {
                boolean take = false;
                if(sum + arr[idx] <= target) take = next[sum+arr[idx]];
                boolean notTake = next[sum];
                curr[sum] = take || notTake;
            }
            next = curr;
        }
        return next[0];
    }

    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }
        if(totSum % 2 != 0) return false;
        int target = totSum/2;
        return isSubsetSum(nums, target);
    }
}