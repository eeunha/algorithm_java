class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        
        int answerI = -1;
        int answerJ = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            if (i % n == 0) {
                answerI++;
                answerJ = 0;
            }
            answer[answerI][answerJ] = num_list[i];
            answerJ++;
        }
        
        return answer;
    }
}