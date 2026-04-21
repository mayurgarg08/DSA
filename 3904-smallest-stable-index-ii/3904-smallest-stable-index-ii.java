class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

          int[] mini = new int[n];
          mini[n - 1] = nums[n - 1];

         for(int i = n - 2; i >= 0; i--) {
            mini[i] = Math.min(nums[i], mini[i + 1]);
         }

        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            int diff = max - mini[i];
            if(diff <= k) return i;
        }

        return -1;
    }
}