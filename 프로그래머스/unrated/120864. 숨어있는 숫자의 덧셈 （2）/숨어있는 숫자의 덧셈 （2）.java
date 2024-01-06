/*
aAb1B2cC34oOp
            ^
현재 문자가 영어다 
    curN이 뭔가 있다 -> sum에 curN 더하기. curN 비우기
    curN이 없다 -> 다음으로 이동
현재 문자가 숫자다 
    -> curN에 저장(stringbuilder append), 다음으로 이동

for문을 다 돌고 나서 curN에 숫자가 남았다면 sum 더하기
sum 반환

curN = 34
sum = 1 + 2 + 34 = 37

time: O(N)
space: O(1)
*/
import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuilder sbCurN = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            char curC = my_string.charAt(i);
            
            if (Character.isLetter(curC) && sbCurN.length() > 0) { // 문자일 때
                answer += Integer.parseInt(sbCurN.toString());
                sbCurN.setLength(0);
            } else if (!Character.isLetter(curC)){ // 숫자일 때
                sbCurN.append(String.valueOf(curC));
            }
        }
        
        if (sbCurN.length() != 0) {
            answer += Integer.parseInt(sbCurN.toString());
        }
        
        return answer;
    }
}