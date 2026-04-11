class Solution {
    public int buyChoco(int[] prices, int money) {
        int temp = money;
        Arrays.sort(prices);
        int count = 0;
        for(int i = 0; i < prices.length; i++) {
            if(money >= prices[i] && count < 2) {
                money -= prices[i];
                count++;
            } else {
                break;
            }
        }
        if(count == 2) return money;
        return temp;
    }
}