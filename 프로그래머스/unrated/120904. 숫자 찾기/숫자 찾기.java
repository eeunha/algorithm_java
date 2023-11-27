class Solution {
    public int solution(int num, int k) {
        int count = -1;
        int answer = -1;
        int length = (num + "").length();
        
        while (num > 0) {
            count++;
            if (num % 10 == k) answer = length - count;
            num /= 10;
        }
        
        return answer;
    }
}