/*
10명 -> 10과 6의 공배수 구하기 -> 30 => / 6 = 5
4명 -> 4와 6의 공배수 구하기 -> 12 => / 6 = 2
*/
class Solution {
    public int solution(int n) {
        //edge cases
        if (n == 1) return 1;
        else if (n % 6 == 0) return n / 6;
        
        int answer = 1;
        
        while (true) {
            if ((n * answer) % 6 == 0) {
                break;
            }
            answer++;
        }
        
        return n * answer / 6;
    }
}