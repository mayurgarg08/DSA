class Solution {
    private int atMost(int[] nums, int goal) {
        if(goal < 0) return 0;
        int left = 0;
        int right = 0;
        int ans = 0;
        int sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            while(sum > goal) {
                sum -= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       int n = nums.length;
       return atMost(nums, goal) - atMost(nums, goal-1);
    }
}