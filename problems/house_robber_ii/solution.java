class Solution {
     private int helper(int[] nums) {
        int n = nums.length;
        int prev = nums[0], prev2 = 0;
        for(int i = 1; i< n; i++) {
            int take = nums[i];
            if(i > 1) take += prev2;

            int notTake = 0 + prev;

            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            temp1[i] = nums[i];
        }
        int ans1 = helper(temp1);
        for(int i = 1; i < n; i++) {
            temp2[i-1] = nums[i];
        }
        int ans2 = helper(temp2);
        return Math.max(ans1, ans2);
    }
}