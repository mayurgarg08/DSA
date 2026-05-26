class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mpp = new HashMap<>();
        for(String word: words) {
             mpp.put(word, mpp.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>(mpp.keySet());

        Collections.sort(list, (a, b) -> {
            if(mpp.get(a).equals(mpp.get(b))) {
                return a.compareTo(b);
            }
            return mpp.get(b) - mpp.get(a);
        });

        return list.subList(0, k);
    }
}