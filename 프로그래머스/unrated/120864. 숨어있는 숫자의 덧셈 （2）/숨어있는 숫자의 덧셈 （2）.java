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
        
        String[] arr = my_string.replaceAll("[a-z|A-Z]", " ").split(" ");
        
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                answer += Integer.parseInt(arr[i]);
            }
        }
        return answer;
    }
}