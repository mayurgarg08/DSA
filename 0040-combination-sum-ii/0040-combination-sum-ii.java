class Solution {
    public void helper(int index, int sum, int n, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index == n || sum > target) {
            return;
        }
        for(int i = index; i < n; i++) {
            if(i  > index && arr[i] == arr[i-1]) continue;
            if(sum + arr[i] > target) break; 
            temp.add(arr[i]);
            helper(i+1, sum + arr[i], n, arr, target, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       int n = candidates.length;
        Arrays.sort(candidates);
       List<List<Integer>> ans = new ArrayList<>();
       helper(0, 0, n, candidates, target, new ArrayList<>(), ans);
       return ans;
    }
}