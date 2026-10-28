class Solution {
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
       if(n == 0) return 0;
       int maxLength = Integer.MIN_VALUE;
       Set<Integer> set = new HashSet<>();
       for(int i : nums) {
          set.add(i);
       }
       for(int it: set) {
         if(!set.contains(it-1)) {
            int length = 0;
            int key = it;
            while(set.contains(key)) {
                length++;
                key++;
            }
            maxLength = Math.max(maxLength, length);
         } 
       }
       return maxLength;
    }
}