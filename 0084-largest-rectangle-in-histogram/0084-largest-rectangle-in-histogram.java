class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
       int maxArea = 0;
       Stack<Integer> stk = new Stack<>();
       for(int i = 0; i < n; i++) {
        while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
            int element = heights[stk.pop()];
            int nse = i;
            int pse = stk.isEmpty()? -1 : stk.peek();
            maxArea = Math.max(maxArea, (nse-pse-1)*element);
        }
        stk.push(i);
       }
       while(!stk.isEmpty()) {
         int element = heights[stk.pop()];
         int nse = n;
         int pse = stk.isEmpty()? -1 : stk.peek();
         maxArea = Math.max(maxArea, (nse-pse-1)*element);
       }
       return maxArea;
    }
}