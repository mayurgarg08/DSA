class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
       for(int i = 0; i < n; i++) {
        Map<Character, Integer> freq = new HashMap<>();
         for(int j = i; j < n; j++) {
              freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

              int max = Integer.MIN_VALUE;
              int min = Integer.MAX_VALUE;

              for(int value : freq.values()) {
                max = Math.max(max, value);
                min = Math.min(min, value);
              }

              int diff = max-min;
              sum += diff;
         }
       }
       return sum;
    }
}