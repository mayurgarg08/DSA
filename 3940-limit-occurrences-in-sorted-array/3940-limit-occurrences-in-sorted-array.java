class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) return new int[]{};
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        int count = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[i-1]) {
                ans.add(nums[i]);
                count = 1;
            } else if(count < k) {
                ans.add(nums[i]);
                count++;
            } else {
                continue;
            }
        }
        int[] result = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}