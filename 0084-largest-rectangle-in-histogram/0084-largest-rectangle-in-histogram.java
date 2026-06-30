class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i <= n; i++) {
          while(!stk.isEmpty() && (i == n || heights[stk.peek()] >= heights[i])) {
              int height = heights[stk.pop()];
              int nse = i;
              int pse = stk.isEmpty() ? -1 : stk.peek();

              int width = nse-pse-1;
              int area = height*width;
              maxArea = Math.max(maxArea, area);
          }
          stk.push(i);
        }
        return maxArea;
    }
}