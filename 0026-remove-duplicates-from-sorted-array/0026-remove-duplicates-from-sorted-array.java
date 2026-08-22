class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 1;
        int last = nums[0];
        int lastIdx = 1;
        for(int i = 1; i < n; i++) {
           if(nums[i] == last) continue;
           else {
            nums[lastIdx] = nums[i];
            last = nums[i];
            lastIdx++;
           }
        }
        return lastIdx;
    }
}