import java.util.*;

class Solution {
    public int solution(String s) {
        //edge cases
        if (s.length() == 1) return 0;
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        int idx = 1;
        
        while (idx < s.length()) {
            char curC = s.charAt(idx);
            
            if (!stack.isEmpty() && stack.peek() == curC) {
                stack.pop();
            } else {
                stack.push(curC);
            }
            idx++;
        }
        
        return (stack.isEmpty()) ? 1 : 0;
    }
}