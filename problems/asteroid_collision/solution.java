class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> lst = new ArrayList<>();
        for(int i = 0; i< asteroids.length; i++) {
            if(asteroids[i] > 0) {
                lst.add(asteroids[i]);
            } else {
                while(lst.size() != 0 && lst.get(lst.size()-1) > 0 && Math.abs(asteroids[i]) > lst.get(lst.size()-1)) {
                    lst.remove(lst.size()-1);
                } 
                if(lst.size() != 0 && lst.get(lst.size()-1)  == Math.abs(asteroids[i])) {
                    lst.remove(lst.size()-1);
                } else if(lst.size() == 0 || lst.get(lst.size()-1) < 0) {
                    lst.add(asteroids[i]);
                }
            }
        }
        int[] result = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            result[i] = lst.get(i);
        }

        return result;
    }
}