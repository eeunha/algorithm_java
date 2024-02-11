class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for (String o : order) {
            answer += (o.contains("la")) ? 5000 : 4500;
        }
        return answer;
    }
}