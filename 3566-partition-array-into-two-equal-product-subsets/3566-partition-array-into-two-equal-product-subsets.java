class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        return helper(0, 1, 1, nums, target);
    }
    private boolean helper(int idx, long prod1, long prod2, int[] nums, long target) {
        if(idx == nums.length) {
            if(prod1 == target && prod2 == target) return true;
            else return false;
        } 
        return helper(idx+1, prod1*nums[idx], prod2, nums, target) || helper(idx+1, prod1, prod2*nums[idx], nums, target);
    }
}