class Solution {
    private void helper(int index, int k, int n, int sum, List<Integer> curr, List<List<Integer>> list) {
        if(sum == n  && curr.size() == k) {
            list.add(new ArrayList<>(curr));
            return;
        }
        if(sum > n || curr.size() > k) {
            return;
        }
        for(int i = index; i<10; i++) {
            curr.add(i);
            helper(i+1, k, n, sum+i, curr, list);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> res = new ArrayList<>();
       helper(1, k, n, 0, new ArrayList<>(), res);
       return res;
    }
}