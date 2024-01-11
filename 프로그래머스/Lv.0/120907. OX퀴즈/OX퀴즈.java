import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            
            String[] quizArr = quiz[i].split(" ");
            
            int n = Integer.parseInt(quizArr[0]);
            
            if (quizArr[1].equals("-")) {
                n -= Integer.parseInt(quizArr[2]);
            } else {
                n += Integer.parseInt(quizArr[2]);
            }
            
            answer[i] = (n == Integer.parseInt(quizArr[4])) ? "O" : "X";
        }
        
        return answer;
    }
}