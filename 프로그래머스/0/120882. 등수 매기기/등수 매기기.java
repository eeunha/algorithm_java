import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[][] sums = new int[score.length][2];
        
        for (int i = 0; i < score.length; i++) {
            sums[i][0] = score[i][0] + score[i][1];
            sums[i][1] = i;
        }
        
        Arrays.sort(sums, (a, b) -> b[0] - a[0]);
        
        int rank = 1;
        for (int i = 0; i < sums.length; i++) {
            if (i > 0 && sums[i][0] != sums[i-1][0]) {
                rank = i + 1;
            }
            answer[sums[i][1]] = rank;
        }
        
        return answer;
    }
}