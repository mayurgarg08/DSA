class Solution {
    private int binarySubarraySum(int[] nums, int goal) {
        if(goal < 0) return 0;
        int count = 0;
        int l = 0, r = 0, sum = 0;
        while(r<nums.length) {
           sum += nums[r];
           while(sum > goal) {
             sum -= nums[l];
             l++;
           }
           count += (r-l+1);
           r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return binarySubarraySum(nums, goal) - binarySubarraySum(nums, goal-1);
    }
}