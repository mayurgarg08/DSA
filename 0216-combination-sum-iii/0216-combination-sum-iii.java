class Solution {
    public void  helper(int k, int sum, int n, int m, List<Integer> temp, List<List<Integer>> ans) {
        if(k == 0 && sum == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(k == 0 || m > 9) return;
        sum += m;
        temp.add(m);
        helper(k-1, sum, n, m+1, temp, ans);
        sum -= m;
        temp.remove(temp.size()-1);
        helper(k, sum, n, m+1, temp, ans);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(k, 0, n, 1, new ArrayList<>(), ans);
        return ans;
    }
}