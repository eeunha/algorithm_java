class Solution {
    private int[] memo;
    
    public int solution(int n) {
        memo = new int[n + 1];
        
        return fibo(n);
    }
    
    public int fibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            if (memo[n] == 0) {
                memo[n] = fibo(n-1) + fibo(n-2);
            }
            return memo[n] % 1234567;
        }
    }
}