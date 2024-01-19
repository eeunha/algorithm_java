class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        
        //두 수의 공약수 찾기
        for (int i = 2; i <= Math.min(numer, denom) && numer > 0 && denom > 0;) {
            if (numer % i == 0 && denom % i == 0) {
                numer /= i;
                denom /= i;
            } else {
                i++;
            }
        }
        
        return new int[]{numer, denom};
    }
}