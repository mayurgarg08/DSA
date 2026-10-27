class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int i, int j, int[] nums) {
        while(i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n-2; i >= 0; i--) {
             if(nums[i] < nums[i+1]) {
                idx = i;
                break;
             }
        } 
        if(idx == -1) {
            reverse(0, n-1, nums);
            return;
        }
        for(int i = n-1; i >= 0; i--) {
            if(nums[i] > nums[idx]) {
                swap(idx, i, nums);
                reverse(idx+1, n-1, nums);
                return;
            }
        }
    }
}