class Solution {
    private void helper(int index, int[] arr, int target, int sum,
                        List<Integer> curr, List<List<Integer>> list) {
        if (sum == target) {
            list.add(new ArrayList<>(curr));
            return;
        }

        if (index == arr.length || sum > target) {
            return;
        }
        helper(index + 1, arr, target, sum, curr, list);

        curr.add(arr[index]);
        helper(index, arr, target, sum + arr[index], curr, list);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
}
