class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
         int cnt1 = 0;
         int cnt2 = 0;
         int el1 = Integer.MIN_VALUE;
         int el2 = Integer.MIN_VALUE;
         
         for(int i = 0; i< nums.length; i++) {
            if(cnt1 == 0 && el2 != nums[i]) {
                el1 = nums[i];
                cnt1 = 1;
            } else if(cnt2 == 0 && el1 != nums[i]) {
                el2 = nums[i];
                cnt2 = 1; 
            }
            else if(el1 == nums[i]) cnt1++;
            else if(el2 == nums[i]) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
         }   
         int count1 = 0;
         int count2 = 0;

         for(int i = 0; i< nums.length; i++) {
            if(nums[i] == el1) {
                count1++;
            } else if(nums[i] == el2) {
                count2++;
            }
         }
         if(count1 > Math.floor(n/3)) ans.add(el1);
         if(count2 > Math.floor(n/3)) ans.add(el2);
         return ans;
    }
}