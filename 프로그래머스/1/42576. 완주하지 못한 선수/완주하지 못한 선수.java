import java.util.*;

/*
I: String[] participant, completion
O: String
C: 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하
    completion의 길이는 participant의 길이보다 1 작습니다.
    참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자
    참가자 중에는 동명이인이 있을 수 있습니다.
E:

ds: 해시맵
algo:

pseudo code:
set 생성
completion을 set에 넣기 -> 키는 이름, 값은 수 (동명이인)
participant 순회
    현재 이름이 completion에 있는지 확인
        없다면 바로 이름 반환
        있다면 set의 값을 1 줄이기.
            줄인 후 값이 0이면 제거

time: O(N)
space: O(N)
*/
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (String p : participant) {
            if (map.getOrDefault(p, 0) == 0) {
                return p;
            }
            map.put(p, map.get(p) - 1);
        }
        
        return null;
    }
}