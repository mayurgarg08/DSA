class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int[] freq = new int[128];
        for(char c: s.toCharArray()) {
            freq[c]++;
        }       
        List<Character> list = new ArrayList<>();
        for(char c: s.toCharArray()) {
            if(!list.contains(c)) {
                list.add(c);
            }
        }
        Collections.sort(list, (a,b) -> freq[b] - freq[a]);

        StringBuilder ans = new StringBuilder();

        for(char c: list) {
            for(int i = 0; i < freq[c]; i++) ans.append(c);
        }
        return ans.toString();
    }
}