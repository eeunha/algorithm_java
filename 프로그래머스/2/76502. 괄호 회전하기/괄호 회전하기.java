import java.util.*;

/*
I: String s
O: int
C: s의 길이는 1 이상 1,000 이하
E: s.length() % 2 != 0 > return 0

[](){}[](){}
     ^    ^

}]()[{}]()[{
     ^    ^

ds: stack
algo:

pseudo:
s의 길이가 홀수면 바로 0을 반환한다.(edge case)
올바른 괄호 문자열의 개수를 저장할 변수를 하나 만든다.
스택 생성
s 2개를 연달아 붙여 문자열을 하나 만든다.
s의 처음부터 s의 길이까지 반복문을 돌려 시작점을 가진다.
시작점부터 끝점(s의 길이만큼 더한 것)까지 올바를 괄호 문자열인지 확인한다.
올바르다면 개수를 증가시킨다.

time: O(N^2)
space: O(N)

solution:
*/
class Solution {
    public int solution(String s) {
        //edge case
        if (s.length() % 2 != 0) return 0;
        
        String ss = s + s;
        int answer = 0;
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            String curStr = ss.substring(i, i + length);
            if (isCorrect(curStr)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isCorrect(String str) {
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            
            if (curChar == '(' || curChar == '[' || curChar == '{') {
                stack.push(curChar);
            } else {
                if (stack.isEmpty()) return false;
                if ((int) (curChar - stack.peek()) == 1 || (int) (curChar - stack.peek()) == 2) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}