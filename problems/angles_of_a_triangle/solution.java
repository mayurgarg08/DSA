class Solution {
    public double[] internalAngles(int[] sides) {
        double a = sides[0], b = sides[1], c = sides[2];
        if(a + b <= c || a + c <= b || b + c <= a)
            return new double[0];
        double A = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2*b*c)));
        double B = Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2*a*c)));
        double C = Math.toDegrees(Math.acos((a*a + b*b - c*c) / (2*a*b)));
        double[] res = new double[]{A, B, C};
        Arrays.sort(res);
        return res;
    }
}