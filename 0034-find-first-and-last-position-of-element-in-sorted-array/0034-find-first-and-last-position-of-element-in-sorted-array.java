class Solution {
    private int first(int[] nums, int x) {
          int ans = -1;
          int low = 0;
          int high = nums.length-1;
          while(low <= high) {
            int mid = (high+low)/2;
            if(nums[mid] == x) {
                ans = mid;
                high = mid-1;
            } else if(nums[mid] > x) high = mid-1;
            else low = mid+1;
          }
          return ans;
    }
    private int last(int[] nums, int x) {
        int ans = -1;
          int low = 0;
          int high = nums.length-1;
          while(low <= high) {
            int mid = (high+low)/2;
            if(nums[mid] == x) {
                ans = mid;
                low = mid+1;
            } else if(nums[mid] < x) low = mid+1;
            else high = mid-1;;
          }
          return ans;
    }
    public int[] searchRange(int[] nums, int target) {
       int fir = first(nums, target);
       if(fir == -1) return new int[] {-1, -1};
       int last = last(nums, target);
       return new int[]{fir, last};
    }   
}