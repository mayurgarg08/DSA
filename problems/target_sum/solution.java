class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int n = nums.length;
         return countPartitions(n, nums, target);   
    }
   public int perfectSum(int[] arr, int K) {
        int n = arr.length;
        int[] prev = new int[K+1];
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        if(arr[0] != 0 && arr[0] <= K) prev[arr[0]] = 1;
        for(int i = 1; i< n; i++) {
            int[] curr = new int[K+1];
            curr[0] = prev[0];
            for(int j = 0; j <= K; j++) {
                 int notPick = prev[j];
                 int pick = 0;
                 if(arr[i] <= j) pick = prev[j-arr[i]];
                 curr[j] = pick + notPick;
            }
            prev = curr;
        }
      return prev[K];
    }
    public int countPartitions(int n, int[] arr, int diff) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if(sum - diff < 0 || (sum-diff) % 2 != 0) return 0;
        int target = (sum-diff)/2;
        return perfectSum(arr, target);
    }
}