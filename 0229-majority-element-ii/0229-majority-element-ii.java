class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int el1 = Integer.MIN_VALUE;
       int el2 = Integer.MIN_VALUE;
       int count1 = 0;
       int count2 = 0;
       int n = nums.length;
       for(int i = 0; i < n; i++) {
          if(count1 == 0 && el2 != nums[i]) {
            el1 = nums[i];
            count1++;
          } else if(count2 == 0 && el1 != nums[i]) {
            el2 = nums[i];
            count2++;
          } else if(nums[i] == el1) count1++;
          else if(nums[i] == el2) count2++;
          else {
            count1--;
            count2--;
          }
       }
       int cnt1 = 0;
       int cnt2 = 0;
       for(int i = 0; i < n; i++) {
         if(nums[i] == el1) cnt1++;
         if(nums[i] == el2) cnt2++;
       }
       List<Integer> ans = new ArrayList<>();
       int mini = (int)(n/3) + 1;
       if(cnt1 >= mini) ans.add(el1);
       if(cnt2 >= mini) ans.add(el2);
       Collections.sort(ans);
       return ans;
    }
}