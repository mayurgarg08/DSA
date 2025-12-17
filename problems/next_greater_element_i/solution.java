class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[10001];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            } 
            nge[nums2[i]] = st.isEmpty()? -1 : st.peek();
            st.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = nge[nums1[i]];
        }
        return nums1;
    }
}