class Solution {
    public long solution(int n) {
        long mod = 1234567;
        long[] memo = new long[n + 2];

        memo[1] = 1;
        memo[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % mod;
        }
        return memo[n];
    }
}