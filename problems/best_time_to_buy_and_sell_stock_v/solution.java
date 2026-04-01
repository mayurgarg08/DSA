class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        final long NEG_INF = Long.MIN_VALUE / 2;
        long[][] after = new long[3][k + 1];

        for (int cap = 0; cap <= k; cap++) {
            after[0][cap] = NEG_INF; 
            after[2][cap] = NEG_INF; 
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            long[][] curr = new long[3][k + 1];
            for (int cap = 0; cap <= k; cap++) {
                curr[0][cap] = NEG_INF;
                curr[2][cap] = NEG_INF;
            }

            for (int cap = 1; cap <= k; cap++) {
                
                curr[1][cap] = Math.max(
                    after[1][cap],                        
                    Math.max(
                        -prices[idx] + after[0][cap],        
                        prices[idx] + after[2][cap]        
                    )
                );

                curr[0][cap] = Math.max(
                    after[0][cap],                       
                    prices[idx] + after[1][cap - 1]        
                );

                curr[2][cap] = Math.max(
                    after[2][cap],                           
                    -prices[idx] + after[1][cap - 1]        
                );
            }
            after = curr;
        }

        return after[1][k];
    }
}