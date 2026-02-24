class Solution {
     private void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        
        List<Integer> temp = new ArrayList<>();
        
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }
        
        while(i <= mid) {
            temp.add(arr[i]);
            i++;
        }
        
        while(j <= end) {
            temp.add(arr[j]);
            j++;
        }
        
        for(int k = start; k <= end; k++) {
            arr[k] = temp.get(k - start);
        }
    }

    private int countPairs(int[] nums, int start, int mid, int end) {
        int right = mid+1;
        int cnt = 0;
        for(int i = start; i <= mid; i++) {
               while(right <= end && nums[i] > 2L*nums[right]) {
                  right++;
               }
               cnt += (right - (mid + 1));
        } 
        return cnt;
    }
    
    private int mergeSort(int[] nums, int start, int end) {
        int cnt = 0;
        if(start >= end) return 0;
        int mid = (start + end) / 2;
        cnt += mergeSort(nums, start, mid);
        cnt += mergeSort(nums, mid + 1, end);
        cnt += countPairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1); 
    }
}