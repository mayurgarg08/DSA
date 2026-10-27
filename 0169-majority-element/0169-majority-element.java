class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length;
       int count = 0;
       int el = -1;
        for(int i = 0; i < n; i++) {
            if(count == 0) {
                el = nums[i];
                count = 1;
            } else if(el == nums[i]) {
                count++;
            } else count--;
        }
        int freq = 0;
        for(int i = 0; i < n; i++) {
           if(nums[i] == el) freq++;
         }
         if(freq > (n/2)) {
            return el;
         }
         return -1;
    }
}