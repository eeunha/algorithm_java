/*
0 또는 양의 정수가 주어졌을 때
정수를 이어 붙여 만들 수 있는 가장 큰 수 알아내기

I: int[] numbers
O: String
C: numbers 원소 = 0 또는 양의 정수
    1 <= numbers.length <= 100000
    0 <= numbers 원소 <= 1000
E: numbers.length == 1 >> return numbers[0] + "";
    정렬 후 배열의 첫번째 값이 0인 경우 > 모든 값이 0 >> return "0"

numbers 숫자를 문자열로 바꾸기
바꾼 배열을 내림차순 정렬 (두 문자를 붙이기 > 숫자로 변경 > 크기비교)
정렬된 배열을 순회하면서 문자열로 더하기(stringbuilder)
문자열 반환

ds: array
algo: sort

solution:
if (numbers.length == 1) return numbers[0] + "";

String[] newNumbers = new String[numbers.length]
for (int i = 0; i < numbers.length; i++) {
    newNumbers[i] = numbers[i] + "";
}
Arrays.sort(newNumbers, (a, b) -> Integer.parseInt(b+a) - Integer.parseInt(a+b)); // Integer로 바꾸면 범위가 벗어날 경우 오류 발생. compareTo로 바꾸기.
// 정렬 후 맨 앞이 "0"인 경우 "0" 반환
StringBuilder sb = new StringBuilder();
for(String s : newNumbers) {
    sb.append(s);
}
return sb.toString();

time: O(NlogN)
space: O(N)
*/
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // edge case
        if (numbers.length == 1) return numbers[0] + "";

        String[] newNumbers = new String[numbers.length];
            
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i] + "";
        }
        
        Arrays.sort(newNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        // edge case
        if (newNumbers[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : newNumbers) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}