class Solution {
    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int it: nums) {
            max = Math.max(it, max);
        }
        return max;
    }
    private int findSum(int[] nums) {
        int total = 0;
        for(int it: nums) {
            total += it;
        }
        return total;
    }
    private boolean isPossible(int mid, int[] nums, int k) {
        int subarrays = 1;
        int sum = 0;
        for(int it: nums) {
            if(sum + it <= mid) {
                sum += it;
            } else {
                subarrays++;
                sum = it;
            }
        }
        return subarrays <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = findMax(nums);
        int high = findSum(nums);
        while(low < high) {
            int mid = (low+high)/2;
            if(isPossible(mid, nums, k)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}