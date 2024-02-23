class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        
        while (answer <= 500 && n != 1) {
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
            answer++;
        }
        
        return (n == 1 && answer <= 500) ? answer : -1;
    }
}