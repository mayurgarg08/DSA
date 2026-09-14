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
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] heights = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}