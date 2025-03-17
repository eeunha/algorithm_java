import java.util.*;

/*
I: String s - 숫자와 Z가 공백으로 구분되어 담긴 문자열
O: int 
C: 1 ≤ s의 길이 ≤ 200
    -1,000 < s의 원소 중 숫자 < 1,000
    s는 숫자, "Z", 공백
    연속된 공백은 주어지지 않습니다.
    0을 제외하고는 0으로 시작하는 숫자는 없습니다.
    s는 "Z"로 시작하지 않습니다.
    s의 시작과 끝에는 공백이 없습니다.
    "Z"가 연속해서 나오는 경우는 없습니다.
E: s.length() == 1 > return Integer.parseInt(s);

문자열의 숫자를 차례대로 더하기
Z가 나오면 바로 전에 더했던 숫자 빼기 -> stack에 저장 -> 안해도 됨. 변수에 저장 (연속 Z 없음)

ds:
algo:

pseudo:
s.length() == 1 > return Integer.parseInt(s);
s를 공백으로 split -> arr생성
int answer 결과값 변수 생성
int add 마지막으로 더한 값 변수 생성
arr 순회
    Z -> answer -= add
    수 -> answer += 수
        add = 수 
answer 반환

time: O(N)
space: O(N)
*/
class Solution {
    public int solution(String s) {
        //edge case
        if (s.length() == 1) 
            return Integer.parseInt(s);
        
        String[] arr = s.split(" ");
        int answer = 0;
        int add = 0;
        
        for (String curArr : arr) {
            if (curArr.equals("Z")) {
                answer -= add;
            } else {
                int n = Integer.parseInt(curArr);
                answer += n;
                add = n;
            }
        }
        return answer;
    }
}