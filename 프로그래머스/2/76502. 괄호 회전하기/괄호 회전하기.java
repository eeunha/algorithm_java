import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) return 0;
        
        // 현재 문자열이 올바른 괄호인가?
        int answer = isCorrect(s) ? 1 : 0;
        
        //회전하기
        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(i));
            sb.append(s.substring(0, i));
            
            if (isCorrect(sb.toString())) {
                answer++;  
            } 
        }
        
        return answer;
    }
    
    public boolean isCorrect (String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            char curC = s.charAt(i);
            
            if (curC == '(' || curC == '{' || curC == '[') {
                stack.push(curC);
            } else if (!stack.isEmpty() 
                       && (curC - stack.peek() == 1 || curC - stack.peek() == 2)) {
                //올바른 쌍인 경우
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}