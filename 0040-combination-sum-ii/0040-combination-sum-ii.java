class Solution {
    private void helper(int idx, int sum, int[] candidates, int target, List<Integer> curr, List<List<Integer>> ans) {
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx == candidates.length || sum > target) {
            return;
        }
        for(int index = idx; index < candidates.length; index++) {
           if(index > idx && candidates[index] == candidates[index-1]) continue;
           if(sum + candidates[index] > target) break;
           curr.add(candidates[index]);
           helper(index+1, sum+candidates[index], candidates, target, curr, ans);
           curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(candidates);
       helper(0, 0, candidates, target, new ArrayList<>(), ans);
       return ans;
    }
}