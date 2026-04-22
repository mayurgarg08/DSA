class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        List<Set<Character>> sets = new ArrayList<>();
        for (String word : words) {
            Set<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            sets.add(set);
        }
        
        int maxProd = 0;
        

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                if (!hasCommon(sets.get(i), sets.get(j))) {
                    int prod = words[i].length() * words[j].length();
                    maxProd = Math.max(maxProd, prod);
                }
            }
        }
        
        return maxProd;
    }
    
    private boolean hasCommon(Set<Character> a, Set<Character> b) {
        for (char c : a) {
            if (b.contains(c)) return true;
        }
        return false;
    }
}