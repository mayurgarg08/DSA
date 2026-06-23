class Solution {
    private void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int k= 0;
        int[] ans = new int[high-low+1];
        while(i <= mid && j <= high) {
           if(nums[i] <= nums[j]) {
            ans[k] = nums[i];
            i++;
           } else {
            ans[k] = nums[j];
            j++;
           }
           k++;
        }
        while(i <= mid) {
            ans[k] = nums[i];
            i++;
            k++;
        }
        while(j <= high) {
            ans[k] = nums[j];
            j++;
            k++;
        }
       for(int l = 0; l < ans.length; l++) {
          nums[low + l] = ans[l];
        }
    }
    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid+1;
        for (int i = low; i <= mid; i++) {
           while (right <= high && (long) nums[i] > 2L * nums[right]) {
               right++;
            }
             count += right - (mid + 1);
        }
        return count;
    }
    private int mergesort(int[] nums, int low, int high) {
        int count = 0;
        if(low >= high) return count;
        int mid = (low+high)/2;
        count += mergesort(nums, low, mid);
        count += mergesort(nums, mid+1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length - 1); 
    }
}