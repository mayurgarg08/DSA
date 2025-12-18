class Solution {
    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    private long sumMin(int[] arr) {
        long total = 0;
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        for(int i = 0; i< n; i++) {
            long left = i - psee[i];
            long right = nse[i]-i;
            total += right*left*arr[i];
        }
        return total;
    }
    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    private int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
     private long sumMax(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);
        int n = arr.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;
            sum += left * right * arr[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }
}