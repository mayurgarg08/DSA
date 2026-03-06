class Solution {
    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int first = 0;
        int second = n-1;
        int count = 0;
        while(first < n && first < second) {
            if(nums[first] != val) {
                first++;
            } else {
                swap(nums, first, second);
                second--;
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}