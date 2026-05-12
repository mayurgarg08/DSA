class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int num: nums) {
            String x = Integer.toString(num);
            for(int i = 0; i < x.length(); i++) {
                lst.add(x.charAt(i) - '0');
            } 
        }
        int[] arr = new int[lst.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = lst.get(i);
        }
        return arr;
    }
}