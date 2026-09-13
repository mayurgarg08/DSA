class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[10001];
        Stack<Integer> stk = new Stack<>();
        for(int i = nums2.length-1; i >= 0; i --) {
           while(!stk.isEmpty() && stk.peek() <= nums2[i]) stk.pop();
           if(!stk.isEmpty()) nge[nums2[i]] = stk.peek();
           else nge[nums2[i]] = -1;
           stk.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = nge[nums1[i]];
        }
        return nums1;
    }
}