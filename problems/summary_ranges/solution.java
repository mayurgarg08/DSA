class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if(n == 0) return ans;
        int start = nums[0];
        for(int i = 1; i< nums.length; i++) {
            if(nums[i-1]+1 != nums[i]) {
                if(nums[i-1] == start) {
                    ans.add(String.valueOf(nums[i-1]));
                } else {
                    ans.add(start+"->"+nums[i-1]);
                }
                start = nums[i];
            } 
        }
        if(nums[n-1] != start) {
            ans.add(start + "->" + nums[n-1]);
        } else {
            ans.add(String.valueOf(start));
        }
        return ans;
    }
}