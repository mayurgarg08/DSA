class Solution {
    private void backtrack(int start, int n, int k, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {

            current.add(i);
            backtrack(i + 1, n, k, result, current);
            current.remove(current.size() - 1);
        }
    }    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, result, new ArrayList<>());
        return result;
    }
}