class Solution {
    private void reverse(int[] arr, int low, int high) {
        while(low <= high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }
    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
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
        reverse(nums, 0, n-1);
        return;
       }
       for(int i = n-1; i >= 0; i--) {
        if(nums[i] > nums[idx]) {
            swap(nums, i, idx);
            break;
        }
       } 
       reverse(nums, idx+1, n-1);
    }
}