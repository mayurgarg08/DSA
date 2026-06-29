class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[10001];
        Stack<Integer> stk = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stk.isEmpty() && stk.peek() <= nums2[i]) stk.pop();
            nge[nums2[i]] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = nge[nums1[i]];
        }
        return nums1;
    }
}