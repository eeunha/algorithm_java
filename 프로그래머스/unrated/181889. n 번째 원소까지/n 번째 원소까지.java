class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];
        for (int i = 0; i <= n-1; i++) {
            answer[i] = num_list[i];
        }
        return answer;
    }
}