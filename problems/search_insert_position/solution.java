class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(target == nums[mid]) {
                return mid;
            } else if(target<nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1; 
            }
        }
        if(target<nums[0]) {
                return 0;
            }
        if(target>=nums[nums.length-1]) {
                return nums.length;
            }    
        for(int i =0; i<nums.length-1;i++) {
            if(nums[i]<target && nums[i+1] > target) {
                return i+1;
            } 
        }
        return -1;
    }
}