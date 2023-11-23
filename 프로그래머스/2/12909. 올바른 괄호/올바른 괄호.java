import java.util.*;

/*
 23.11.23
 
 I: String s
 O: boolean
 C: 문자열 S의 길이 <= 100000 자연수
 	문자열 s = ( or )
 E: 시작 문자가 ) || 마지막 문자가 ( => false
 	s.length % 2 == 1 => false
 
 ds: stack
 algo: stack
 
 
 time: O(n), n = s.length()
 space: O(n), n = s.length()
*/
class Solution {
    boolean solution(String s) {
        // edge cases
		if (s.length() % 2 == 1 || s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
			return false;
		}

		Stack<Character> stack = new Stack<>();

		// 한 문자씩 보기
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			if (cur == '(') {
				stack.push(cur);
			} else {
				if (stack.empty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}

		// 다 돌았는데 스택에 값이 남아있다면 올바르지 않음. -> false
		// 올바르면 true
		return (stack.empty()) ? true : false;
    }
}