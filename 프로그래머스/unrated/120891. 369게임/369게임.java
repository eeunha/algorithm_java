class Solution {
    public int solution(int order) {
        int answer = 0;
        int curN;
        while (order > 0) {
            curN = order % 10;
            if (curN == 3 || curN == 6 || curN == 9) {
                answer++;
            }
            order /= 10;
        }
        return answer;
    }
}