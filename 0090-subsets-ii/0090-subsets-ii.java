class Solution {
    private void helper(int idx, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        ans.add(new ArrayList<>(curr));
        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            helper(i+1, nums, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}