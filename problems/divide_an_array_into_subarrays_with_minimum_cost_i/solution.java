class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        if(n == 3) return nums[0] + nums[1] + nums[2];
        int ans = nums[0];
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            if(nums[i] < smallest) {
                second = smallest;
                smallest = nums[i];
            } else if(nums[i] < second) second = nums[i];
        }
        ans += smallest;
        ans += second;
        return ans;
    }
}