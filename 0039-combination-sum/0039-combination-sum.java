class Solution {
    private void helper(int index, int sum, int n, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(index == n || sum > target) {
            return;
        }
        temp.add(arr[index]);
        sum += arr[index];
        helper(index, sum, n, arr, target, temp, ans);
        temp.remove(temp.size()-1);
        sum -= arr[index];
        helper(index+1, sum, n, arr, target, temp, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, 0, n, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
}