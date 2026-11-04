class Solution {
    private int[] nse(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
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
    private int[] pse(int[] arr) {
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
    private long sumMin(int[] arr) {
        int n = arr.length;
        int[] nsee = nse(arr);
        int[] psee = pse(arr);
        long total = 0;
        for(int i = 0; i < n; i++) {
            long left = i - psee[i];
            long right = nsee[i] - i;
            total = (total + (left * right * arr[i])); 
        }
        return total;
    }
    private int[] nge(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
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
    private int[] pge(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && arr[stk.peek()] < arr[i]) {
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
    private long sumMax(int[] arr) {
        int n = arr.length;
        int[] ngee = nge(arr);
        int[] pgee = pge(arr);
        long total = 0;
        for(int i = 0; i < n; i++) {
            long right = ngee[i] - i;
            long left = i - pgee[i];
            total = (total + (left * right * arr[i]));
        }
        return total;
    }
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }
}