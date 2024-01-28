class Solution {
    public int solution(String number) {
        int answer = 0;
        for (int i = 0; i < number.length(); i++) {
            char curN = number.charAt(i);
            answer += curN - '0';
        }
        return answer % 9;
    }
}