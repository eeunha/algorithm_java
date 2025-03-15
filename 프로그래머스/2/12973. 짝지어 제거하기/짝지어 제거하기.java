import java.util.*;

/*
I: 알파벳 소문자로 이루어진 String
O: int
C: 문자열의 길이 : 1,000,000이하의 자연수
    문자열은 모두 소문자로 이루어져 있습니다.
E: 문자열의 길이가 홀수면 0 반환

문자열에서 같은 알파벳이 2개 붙어있는 짝 찾기
둘 제거하기
앞뒤로 문자열 이어붙이기
문자열 모두 제거할 때까지 반복
성공적으로 수행 시 1, 아닐 땐 0 반환

ds: stack
algo:

pseudo:
s의 길이가 홀수면 0 반환
스택 하나 생성
s 처음부터 끝까지 한 문자씩 본다.
스택이 비어있다면 스택에 값 넣기
비어있지 않다면 맨 위의 값과 현재 값이 같은지 확인
    같다면 pop
    다르다면 push
스택이 비어있다면 1, 아니면 0 반환 

time: O(N)
space: O(N)

solution:
*/
class Solution
{
    public int solution(String s)
    {
        //edge case
        if (s.length() % 2 == 1) return 0;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curS = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == curS) {
                stack.pop();
            } else {
                stack.push(curS);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}