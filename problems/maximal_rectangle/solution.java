class Solution {
    private int largestHist(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i< heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty()?-1:st.peek(); 
                maxArea = Math.max(maxArea, heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int element = st.peek();
            st.pop();
            int nse = heights.length ;
            int pse = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[][] psum = new int[matrix.length][matrix[0].length]; 
        for(int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for(int i = 0; i< matrix.length; i++) {
                if (matrix[i][j] == '1') {
                sum += 1;
            } else {
                sum = 0;
            }
                psum[i][j] = sum;
            }
        }
        for(int i = 0; i< matrix.length; i++) {
            maxArea = Math.max(maxArea, largestHist(psum[i]));
        }
        return maxArea;
    }
}