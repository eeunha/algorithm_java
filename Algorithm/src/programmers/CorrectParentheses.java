package programmers;

import java.util.Stack;

/*
I: String
O: boolean
C: 문자열 s의 길이 : 100,000 이하의 자연수
    문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
E: if (s.length % 2 == 1) return false;

solution:
스택이 비었을 경우 - 첫 문자를 스택에 넣기
여는 괄호인 경우 - 스택에 넣기
닫는 괄호인 경우 - pop 하기

-> 스택을 굳이 쓰지 않아도 된다.
여는 괄호인 경우 개수만 카운팅해도 된다.
여는 괄호면 카운트 +1, 닫는 괄호면 카운트 -1
마지막까지 다 돌았을 때 카운트가 0이면 true, 아니면 false

-> 아니다. 스택을 쓰지 않으면 올바르지 않은 괄호를 확인할 수 없다.
결국 스택을 쓰자.

time: O(N)
space: O(N)
*/

public class CorrectParentheses {
	boolean solution(String s) {
		// edge cases
		if (s.length() % 2 == 1)
			return false;

		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				if (stack.size() == 0) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		return (stack.size() == 0) ? true : false;
	}
	
	boolean solution2(String s) {
        //edge cases
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 && s.charAt(i) == '(') || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (stack.size() == 0) {
                return false;
            } else {
                stack.pop();
            }
        }
        
        return (stack.size() == 0) ? true : false;
    }


}
