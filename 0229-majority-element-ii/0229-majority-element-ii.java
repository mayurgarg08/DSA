class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int count1 = 0;
        int el1 = -1;
        int count2 = 0;
        int el2 = -1;
        for(int i = 0; i < n; i++) {
          if(count1 == 0 && el2 != nums[i]) {
             el1 = nums[i];
             count1 = 1;
          } else if(count2 == 0 && el1 != nums[i]) {
             el2 = nums[i];
             count2 = 1;
          } else if(nums[i] == el1) {
             count1++;
          } else if(nums[i] == el2) {
             count2++; 
          } else {
            count1--;
            count2--;
          }
        } 
        int freq1 = 0;
        int freq2 = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == el1) freq1++;
            else if(nums[i] == el2) freq2++;
        }
        if(freq1 > n/3) ans.add(el1);
        if(freq2 > n/3) ans.add(el2);
        return ans;
    }
}