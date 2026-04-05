class Solution {
    public List<Integer> findGoodIntegers(int n) {
         Map<Integer, List<int[]>> map = new HashMap<>();

        int limit = (int) Math.cbrt(n);

        for (int a = 1; a <= limit; a++) {
            for (int b = a; b <= limit; b++) {
                int sum = a*a*a + b*b*b;

                if (sum > n) break;

                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(new int[]{a, b});
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int sum : map.keySet()) {
            if (map.get(sum).size() >= 2) {
                result.add(sum);
            }
        }

        Collections.sort(result);
        return result;
    }
}