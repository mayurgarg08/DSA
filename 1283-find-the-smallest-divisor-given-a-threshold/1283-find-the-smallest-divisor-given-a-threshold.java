class Solution {
    private int maxi(int[] arr) {
        int maxim = Integer.MIN_VALUE;
        for(int num: arr) {
            maxim = Math.max(maxim, num);
        }
        return maxim;
    }
    private int sum(int[] nums, int mid) {
        int sum = 0;
         for(int num: nums) {
            sum += Math.ceil((double)(num) / (double)(mid));
         }
         return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = maxi(nums);
        int ans = 0;
        while(low <= high) {
            int mid = (high+low)/2;
            if(sum(nums, mid) <= threshold) {
                ans = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return ans;
    }
}