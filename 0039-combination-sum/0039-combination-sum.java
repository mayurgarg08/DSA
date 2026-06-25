class Solution {
    private void helper(int idx, int sum, int[] arr, int target, List<Integer> curr, List<List<Integer>> ans) {  
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(idx == arr.length || sum > target) return;
        helper(idx+1, sum, arr, target, curr, ans);
        curr.add(arr[idx]);
        helper(idx, sum+arr[idx], arr, target, curr, ans);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(0, 0, candidates, target, curr, ans);
        return ans;
    }
}