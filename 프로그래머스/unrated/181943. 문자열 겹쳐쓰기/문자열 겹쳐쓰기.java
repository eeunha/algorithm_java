/*
I: String my_string, overwrite_string & int s
O: String
C: my_string와 overwrite_string은 숫자와 알파벳으로 이루어져 있습니다.
    1 ≤ overwrite_string의 길이 ≤ my_string의 길이 ≤ 1,000
    0 ≤ s ≤ my_string의 길이 - overwrite_string의 길이
E: if (s == 0 && overwrite_string.length() == my_string.length()) return overwrite_string;
 => if (overwrite_string.length() == my_string.length()) return overwrite_string;

ex)
He11oWor1d -> lloWorl , i=2 부터 i += 7-1 까지 덮어쓰기
  ^     ^
=> HelloWorld
시작 인덱스 = s
끝 인덱스 = s + overwrite_string.length() - 1

Program29b8UYP -> merS123, i=7부터 ~ i=i+6 = 13 까지 덮어쓰기
       ^     ^
ProgrammerS123

1. my_string의 시작인덱스 ~ 끝 까지 문자열을 덮어쓰기
2. my_string의 시작인덱스 ~ 중간 인덱스 까지 문자열을 덮어쓰기 + 중간 인덱스 ~ 끝까지 기존 문자열 더하기

바꿔야 할 인덱스의 시작위치 & 끝위치 찾기
끝 위치가 my_string의 끝과 같은가, 아니면 그보다 짧은가 확인하기

시작 위치: s
끝 위치: s + overwrite_string.length() - 1

if (my_string.length() - 1 > s + overwrite_string.length() - 1)  { // 기존 문자열이 더 긴 경우
    //기존의 끝쪽 문자열 더하기
}

DS: x
Algo: 순회

pseudo code:
stringbuilder sb 생성
시작 ~ s 이전 인덱스까지 my_string을 sb에 append
s ~ s+overwrite_string.length()-1 까지 overwrite_string을 sb에 append
끝 문자열이 남은 경우만 my_string을 추가로 append
return sb.toSting();

time: O(1)
space: O(1)
*/
class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        //edge cases
        if (overwrite_string.length() == my_string.length()) return overwrite_string;
        
        // stringbuilder sb 생성
        StringBuilder sb = new StringBuilder();
        
        // 시작 ~ s 이전 인덱스까지 sb에 my_string을 append
        sb.append(my_string.substring(0, s));
        
        // s ~ s+overwrite_string.length()-1 까지 sb에 overwrite_string을 append
        // sb.append(overwrite_string.substring(s, overwrite_string)) // 바로 문자열 넣으면 된다. 잘라서 계산할 필요가 없다.
        sb.append(overwrite_string);
        
        // 끝 문자열이 남은 경우만 추가로 my_string을 append
        if (my_string.length() - 1 > s + overwrite_string.length() - 1)  { // 기존 문자열이 더 긴 경우
            sb.append(my_string.substring(s + overwrite_string.length()));
        }
        
        return sb.toString();
    }
}