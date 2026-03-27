class Solution {
    private boolean isSubsetSum(int[] arr, int target) {
      int n = arr.length;
      int[] prev = new int[target+1];
      prev[0] = 1;
      if(arr[0] <= target) prev[arr[0]] = 1; 
      for(int i = 1; i < n; i++) {
        int[] curr = new int[target+1];
        curr[0] = 1;
        for(int j = 1; j <= target; j++) {
             boolean notTake = prev[j] == 1;
             boolean take = false;
             if(arr[i] <= j) take = prev[j-arr[i]] == 1;

             curr[j] = (take || notTake) ? 1 : 0;
        }
        prev = curr;
      }
      return prev[target] == 0? false: true;
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