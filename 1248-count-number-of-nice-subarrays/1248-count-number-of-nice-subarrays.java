class Solution {
    private int atMost(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int ans = 0;
        while(right < n) {
            if(nums[right]%2 != 0) {
                count++;
            }
            while(count > k) {
                if(nums[left]%2 != 0) {
                    count--;
                }
                left++;
            }
            ans += (right-left+1);
            right++;
        }
        return ans;
   }
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        return atMost(nums, k) - atMost(nums, k-1);
    }
}