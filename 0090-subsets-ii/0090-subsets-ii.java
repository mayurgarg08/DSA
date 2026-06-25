class Solution {
    private void helper(int idx, int n, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for(int i = idx; i < n; i++) {
            if(i != idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(i+1, n, nums, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, n, nums, new ArrayList<>(), ans);
        return ans;
    }
}