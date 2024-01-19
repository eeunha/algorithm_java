class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        
        int i = Math.min(numer, denom);
        
        while (numer > 0 && denom > 0 && i > 1) {
            if (numer % i == 0 && denom % i == 0) {
                numer /= i;
                denom /= i;
            } else {
                i--;
            }
        }
        
        return new int[]{numer, denom};
    }
}