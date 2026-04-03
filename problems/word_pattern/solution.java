class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mpp = new HashMap<>();
        Map<String, Character> set = new HashMap<>();
        boolean ans = true;
        String[] arr = s.split(" "); 
         if(pattern.length() != arr.length) return false;
        for(int i = 0; i < arr.length; i++) {
            if(!mpp.containsKey(pattern.charAt(i))) {
                mpp.put(pattern.charAt(i), arr[i]);
            } else {
                String temp = mpp.get(pattern.charAt(i));
                if(!temp.equals(arr[i])) {
                    ans = false;
                    break;
                } 
            }
            if(!set.containsKey(arr[i])) {
                set.put(arr[i], pattern.charAt(i));
            } else {
                char temp = set.get(arr[i]);
                if(temp != pattern.charAt(i)) {
                    ans = false;
                    break;
                } 
            }
        }
        return ans;
    }
}