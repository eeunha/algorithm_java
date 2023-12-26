import java.util.*;

/*
 23.12.26
 
 I: String s
 O: boolean
 C: 문자열 S의 길이 <= 100000 자연수
 	문자열 s = ( or )
 E: 시작 문자가 ) || 마지막 문자가 ( => false
 	s.length % 2 == 1 => false
 
 ds: 
 algo: stack
 
 
 time: O(n), n = s.length()
 space: O(1)
*/
class Solution {
    boolean solution(String s) {
        int count = 0;

		for (int i = 0; i < s.length(); i++) {

			count += (s.charAt(i) == '(') ? 1 : -1;

			if (count < 0)
				return false;
		}
        
		return (count > 0) ? false : true;
    }
}