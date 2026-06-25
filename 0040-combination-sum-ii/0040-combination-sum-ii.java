class Solution {
    private void helper(int idx, int sum, int[] arr, int target, List<Integer> curr, List<List<Integer>> ans) {
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < arr.length; i++) {
            if(i != idx && arr[i] == arr[i-1]) continue;
            if (sum + arr[i] > target) break;
            curr.add(arr[i]);
            helper(i+1, sum+arr[i], arr, target, curr, ans);
            curr.remove(curr.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, 0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
}