class Solution {
    public int solution(int n) {
        int sum = 1;
        for (int i = 1; i > 0; i++) {
            sum *= i;
            if (sum > n) return i - 1;
        }
        return 1;
    }
}