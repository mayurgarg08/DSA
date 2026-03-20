class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        for(int i = 1; i < 101; i++) {
            freq[i] += freq[i-1];
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = freq[nums[i]-1];
            }
        }
        return ans;
    }
}