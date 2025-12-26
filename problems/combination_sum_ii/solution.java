class Solution {
    private void helper(int index, int[] arr, int target, int sum, List<Integer> curr, List<List<Integer>> result) {
        if(sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < arr.length; i++) {

            if (i > index && arr[i] == arr[i - 1]) continue;

            if (sum + arr[i] > target) break;

            curr.add(arr[i]);
            helper(i + 1, arr, target, sum + arr[i], curr, result);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(0, candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
}