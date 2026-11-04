class Solution {
    private int[] nextSmall(int[] arr) {
       Stack<Integer> stk = new Stack<>();
       int n = arr.length;
       int[] ans = new int[n];
       for(int i = n-1; i >= 0; i--) {
          while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
            stk.pop();
          }
          if(stk.isEmpty()) {
            ans[i] = n;
          } else {
            ans[i] = stk.peek();
          }
          stk.push(i);
       }
       return ans;
    }
    private int[] preSmall(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
           while(!stk.isEmpty() && arr[stk.peek()] > arr[i]) {
            stk.pop();
           }
           if(stk.isEmpty()) {
              ans[i] = -1;
           } else {
              ans[i] = stk.peek();
           }
           stk.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;
        int[] nse = nextSmall(arr);
        int[] pse = preSmall(arr);
        long total = 0;
        for(int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (left * right * arr[i])%MOD)%MOD;
        }
        return (int)total;
    }
}