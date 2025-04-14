import java.util.*;

/*
I: String[] id_list, report, int k
O: int[]
C:
E:

동일 유저 신고 횟수는 1회
k번 이상 신고 시 정지 후 신고한 유저에게 알림메일 발송
신고가 모두 이루어진 후 이용 정지 + 메일 발송
1. 누가 누구를 신고했는지
2. 신고 당한 사람이 몇회 신고 당했는지

당한사람 - set[신고자, 신고자 2, ...]
id_list id - index

map 순회하면서 해당 사람의 값, 즉 set의 크기가 k 이상인 경우
    set 읽어서 result 에 1씩 값 추가

ds: map, set
algo:

pseudo code:
결과 배열 하나 생성


time:
space:
*/
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> idxMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        
        // id와 index 맵 생성
        for (int i = 0; i < id_list.length; i++) {
            idxMap.put(id_list[i], i);
        }
        
        // 신고 맵 생성
        for (String s : report) {
            String[] curReport = s.split(" ");
            
            if (!reportMap.containsKey(curReport[1])) {
                HashSet<String> idSet = new HashSet<>();
                reportMap.put(curReport[1], idSet);
            }
            
            HashSet<String> idSet = reportMap.get(curReport[1]);
            idSet.add(curReport[0]);
            
            reportMap.put(curReport[1], idSet);
        }
        
        for (Map.Entry<String, HashSet<String>> entry : reportMap.entrySet()) {
            HashSet<String> report_id = entry.getValue();
            
            if (report_id.size() >= k) { // 정지회원일 경우
                for (String s : report_id) {
                    answer[idxMap.get(s)]++;
                }
            }
        }
        
        return answer;
    }
}