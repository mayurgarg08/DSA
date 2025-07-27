class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int curr_Sum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            curr_Sum += nums[right];
            while(curr_Sum >= target) {
                if(right-left+1 < minLength) {
                    minLength = right-left+1;
                }
                curr_Sum -= nums[left];
                left++;
            }
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;   
    }
}