/*
I: String s
O: boolean
C: 문자열 s의 길이 : 100,000 이하의 자연수
    문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
E: if s.length() % 2 != 0 > return false;

ds: stack -> 여는 괄호 개수만 세기
algo:

pseudo:
s의 길이가 홀수 -> false 리턴
여는 괄호 개수 증가시킬 변수 생성
s를 한 문자씩 읽기
    여는 괄호 -> 개수 증가
    닫는 괄호 -> 여는 괄호 개수 확인
        여는 괄호가 있다면 수 하나 줄이기
        없다면 false 반환
여는 괄호 개수가 0이면 true 아니면 false 반환

time: O(N) N은 s.length()
space: O(1)

solution:
*/
class Solution {
    boolean solution(String s) {
        // edge case
        if (s.length() % 2 != 0) return false;

        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) return false;
                count--;
            }
        }

        return count > 0 ? false : true;
    }
}