class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min_diff = Integer.MAX_VALUE;
        int closest_sum = 0;
        for(int i = 0; i< nums.length; i++) {
            int curr_sum = 0;
            int curr_diff = 0;
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
               curr_sum = nums[i] + nums[left] + nums[right];
               curr_diff = Math.abs(target - curr_sum);
               if(curr_diff < min_diff) {
                min_diff = curr_diff;
                closest_sum = curr_sum;
               }
               if(curr_sum < target) {
                left++;
               } else {
                right--;
               }

            }
            
          
        }
        return closest_sum;
    }
}