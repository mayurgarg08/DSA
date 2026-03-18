class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int[] diff = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            diff[i] = prices[i+1]-prices[i];
        }
        for(int i = 0; i < n-1; i++) {
            if(diff[i] < 0) {
               continue;
            }
            profit += diff[i];
        }
        return profit;
    }
}