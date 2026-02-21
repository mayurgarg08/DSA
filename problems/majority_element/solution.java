class Solution {
    public int majorityElement(int[] nums) {
        int element = -1;
        int count = 0;
        for(int i = 0; i< nums.length; i++) {
            if(count == 0) {
                element = nums[i];
                count = 1;
            } else if(nums[i] == element) {
                 count++;
            } else {
                count--;
            }
        }
        int cnt = 0;
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == element) {
                cnt++;
            }
        }
        if(cnt > nums.length/2) {
            return element;
        }
        return -1;
    }
}