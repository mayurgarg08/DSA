class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;
        int lowest = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (high+low)/2;
            if(nums[low] <= nums[mid]) {
                lowest = Math.min(lowest, nums[low]);
                low = mid+1;
            } else {
               lowest = Math.min(lowest, nums[mid]);
               high = mid-1;
            } 
        }
        return lowest;
    }
}