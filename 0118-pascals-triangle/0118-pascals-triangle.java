class Solution {
    private List<Integer> generateRow(int i) {
        List<Integer> temp = new ArrayList<>();
        int ans = 1;
        temp.add(ans);
        for(int j = 1; j < i; j++) {
            ans = ans * (i-j);
            ans = ans/j;
            temp.add(ans);
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();
       temp.add(1);
       ans.add(new ArrayList<>(temp));
       if(numRows == 1) return ans;
       for(int i = 2; i <= numRows; i++) {
          ans.add(generateRow(i));
       }
       return ans;
    }
}