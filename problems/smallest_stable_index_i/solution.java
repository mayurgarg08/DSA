class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] maxi = new int[n];
        int[] mini = new int[n];

        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxi[i] = max;
        }

        for(int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            mini[i] = min;
        }

        for(int i = 0; i < n; i++) {
            int diff = maxi[i] - mini[i];
            if(diff <= k) return i;
        }

        return -1;
    }
}