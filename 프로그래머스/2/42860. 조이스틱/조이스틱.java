/*
I: String name 만들고자 하는 이름
O: int 조이스틱 조작 횟수의 최소값
C: name은 알파벳 대문자로만 이루어져 있습니다.
   name의 길이는 1 이상 20 이하 
E: name.length() == 1 -> return name.charAt(0) - 'A';

이동횟수
A ~ Z -> 0 ~ 25
근데 Z의 이동횟수가 1이기도 하다. A 에서 한칸 아래로 움직였다.

위로만 움직일 때
ABCDEFGHIJ K  L  M  N  O  P  QRSTUVWXY Z
0          10 11 12 13 14 15           25

아래로만 움직일 때
ABCDEFGHIJ K L M  N  O  P  Q  RSTUVWXY Z
0              14 13 12 11 10          1

위로 움직이는 M -> 'M' - 'A' = 12

위로 움직이는 O -> 'O' - 'A' = 14
아래         O -> 'O'

N 기준, A ~ N -> 위쪽 이동이 더 적게 움직임. -> 현재 문자 - 'A'
O ~ Z -> 아래쪽 이동이 더 적게 움직임. -> 'Z' - '현재 문자' + 1


방향을 이동하는 경우
1. 처음부터 쭉 오른쪽으로 이동 -> 두 번째 자리가 A가 아닌 경우
2. 처음 자리 변경 후 쭉 왼쪽으로 이동 -> 두 번째 자리가 A인 경우

횟수를 세는 경우
1. 알파벳 변경 시 -> 알파벳이 A가 아닌 경우 && 현재 자리 문자가 완성되지 않은 경우 => 그 횟수만큼 더하기
2. 자리 변경 시 -> 다음 자리가 변경 되어야 하거나, 그 다음 문자로 넘어가는 경우 => word.length() - 1이 최대

문자를 만드는 경우
1. word.charAt(i) - 'N' <= 0 -> 현재 문자가 N보다 작다는 뜻 -> 현재 문자 - 'A'
2. word.charAt(i) - 'N' > 0 -> 현재 문자가 N보다 크다는 뜻 -> 'Z' - '현재 문자' + 1

문자 변경이 완료되었을 때
-> madeWord 배열에 word.charAt(i) 넣기.

풀이 순서
1. 첫 번째 문자
    -> 변경해야 하는가
2. 현재 문자가

JABAZ 
-> 9 + 1 + 1 + 1 + 1 + 1
-> 9 + 1 + 1 + 1 + 2

ds:
algo: greedy

time: O(N)
space: O(1)
*/
import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직임 수를 체크

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A 갯수 확인
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - index);
            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }
}