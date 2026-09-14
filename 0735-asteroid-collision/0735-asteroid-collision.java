class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       int n = asteroids.length;
       List<Integer> list = new Stack<>();
       for(int i = 0; i < n; i++) {
        if(asteroids[i] > 0) list.add(asteroids[i]);
        else{
           while(list.size() > 0 && list.get(list.size()-1) > 0 && list.get(list.size()-1) < Math.abs(asteroids[i])) {
              list.remove(list.size()-1);
           }
           if(list.size() > 0 && list.get(list.size()-1) == Math.abs(asteroids[i])) {
            list.remove(list.size()-1);
           } else if(list.size() == 0 || list.get(list.size()-1) < 0) {
              list.add(asteroids[i]);
           }
        }   
       } 
       int[] ans = new int[list.size()];
       for(int i = 0; i < list.size(); i++) {
        ans[i] = list.get(i);
       }
       return ans;
    }
}