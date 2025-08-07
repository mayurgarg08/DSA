class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) +1);

            if(map.get(num) > nums.length/3) {
                if(!list.contains(num)) {
                   list.add(num);
                }
                
            }
        }
        return list;
    }
}