class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxAccount = 0;
        
        for(int[] arr: accounts) {
            int maxWealth = 0;
            for(int num: arr) {
               maxWealth += num;
            }
            if(maxAccount < maxWealth) {
                maxAccount = maxWealth;
            }
        }
        return maxAccount;
    }
}