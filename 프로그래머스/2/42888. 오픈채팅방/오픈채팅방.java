import java.util.*;

/*
I: String[] record
O: String[]
C:
E:

누가 들어오면 - 닉네임님이 들어왔습니다
누가 나가면 - 닉네임님이 나갔습니다

닉네임 변경법
1. 채팅방 나간 후 새 닉네임으로 들어감
2. 채팅방에서 변경 -> 기존 채팅방의 메시지 모두 변경

중복 닉네임 허용

무지 등장
프로도 등장
무지 나감
무지가 프로도로 들어옴
프로도가 라이언으로 변경

ds: 맵
algo:

pseudo code:
결과 배열 개수 셀 변수 생성
record 순회하면서 닉네임 맵 생성
    enter - 아이디(키), 닉네임(값) 넣기
    change - 아이디(키), 새 닉네임(값) 넣기
    enter와 leave일 때 변수값 ++

String 배열 하나 생성
다시 record 순회하면서 result 생성
    E로 시작 - id 가져오기 - 맵에서 현재 닉네임 가져오기 - (닉네임)님이 들어왔습니다. 만들기 -> 배열에 넣기
    L로 시작 - id 가져오기 - 맵에서 현재 닉네임 가져오기 - (닉네임)님이 나갔습니다. 만들기 -> 배열에 넣기
    
time: O(N)
space: O(N)
*/
class Solution {
    public String[] solution(String[] record) {
        int resultLength = 0;
        
        HashMap<String, String> map = new HashMap<>();
        
        for (String s : record) {
            if (s.startsWith("L")) {
                resultLength++;
                continue;
            }
            
            if (s.startsWith("E")) {
                resultLength++;
            }
            
            String[] arr = s.split(" ");
            map.put(arr[1], arr[2]);
        }
        
        String[] answer = new String[resultLength];
        int idx = 0;
        
        for (String s : record) {
            if (s.startsWith("C")) continue;
            
            String[] arr = s.split(" ");
            
            answer[idx] = s.startsWith("E") ? map.get(arr[1]) + "님이 들어왔습니다.": map.get(arr[1]) + "님이 나갔습니다.";
            
            idx++;
        }
        
        return answer;
    }
}