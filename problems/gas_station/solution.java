class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
       for(int i = 0; i < n; i++) {
           totalGas = totalGas + gas[i];
           totalCost = totalCost + cost[i];
       } 
        if(totalCost > totalGas) return -1;
        int currGas = 0;
        int start = 0; 
        for(int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];
            if(currGas < 0) {
                start = i+1;
                currGas = 0;
            }
        }
        return start;
    }
}