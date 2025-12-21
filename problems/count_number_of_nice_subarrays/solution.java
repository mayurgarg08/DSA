class Solution {
    private int noOfSubarray(int[] nums, int k) {
        int count = 0, res = 0;
        int l = 0, r = 0, sum = 0;
        while(r<nums.length) {
           sum += nums[r]%2;
           while(sum > k) {
              sum -= nums[l]%2;
              l++;
           }
           count += r-l+1;
           r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return noOfSubarray(nums, k)-noOfSubarray(nums, k-1);
    }
}