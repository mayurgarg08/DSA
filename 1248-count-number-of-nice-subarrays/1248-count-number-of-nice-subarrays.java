class Solution {
    private int atMost(int[] nums, int k) {
        if(k < 0) return 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int count = 0;
        int odds = 0;
        while(r < n) {
            if(nums[r]%2 == 1) odds++;
            if(odds > k) {
                while(odds > k) {
                    if(nums[l]%2 == 1) odds--;
                    l++;
                }
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
}