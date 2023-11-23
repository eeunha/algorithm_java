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
 space: O(1)
*/
class Solution {
    boolean solution(String s) {
        // edge cases
		if (s.length() % 2 == 1 || s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
			return false;
		}

		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			if (cur == '(') {
				count++;
			} else {
				if (count == 0) {
					return false;
				} else {
					count--;
				}
			}
		}

		return (count == 0) ? true : false;
    }
}