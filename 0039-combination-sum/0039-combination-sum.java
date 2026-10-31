class Solution {
    private void helper(int idx, int sum, int[] candidates, int target, List<Integer> curr, List<List<Integer>> ans) {
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx == candidates.length || sum > target) {
            return;
        }
        helper(idx+1, sum, candidates, target, curr, ans);
        curr.add(candidates[idx]);
        helper(idx, sum+candidates[idx], candidates, target, curr, ans);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, 0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
}