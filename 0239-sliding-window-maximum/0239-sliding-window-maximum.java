class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n = nums.length;
      List<Integer> ans = new ArrayList<>();
      Deque<Integer> deq = new LinkedList<>();
      for(int i = 0; i < n; i++) {
        if(!deq.isEmpty() && deq.peekFirst() <= i-k) {
            deq.pollFirst();
        }
        while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
            deq.pollLast();
        }
        deq.offerLast(i);
        if(i >= k-1) ans.add(nums[deq.peekFirst()]);
      }
      int[] result = new int[ans.size()];
      for(int i = 0; i < ans.size(); i++) {
          result[i] = ans.get(i);
      }
      return result;
    }
}