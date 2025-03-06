import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                score1++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                score2++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                score3++;
            }
        }

        int max = Math.max(Math.max(score1, score2), score3);

        ArrayList<Integer> list = new ArrayList<>();

        if (score1 == max) { list.add(1); }
        if (score2 == max) { list.add(2); }
        if (score3 == max) { list.add(3); }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}