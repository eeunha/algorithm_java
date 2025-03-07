import java.util.*;

/*
실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수

I: int N 전체 스테이지 개수, int[] stages 게임 이용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
O: int[] 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담긴 배열
C: 스테이지의 개수 N은 1 이상 500 이하의 자연수
    stages의 길이는 1 이상 200,000 이하
    stages에는 1 이상 N + 1 이하의 자연수
    각 자연수는 사용자가 현재 도전 중인 스테이지의 번호
    N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자
    만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
    스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
E: 

pseudo code:
실패율 구하기
실패율이 큰 것부터 내림차순으로 스테이지 번호 넣기
안넣은 스테이지는 오름차순으로 뒤에 채워넣기

time:
space:

solution:

*/
class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] challenger = new int[N + 2];
        
        for (int stage : stages) {
            challenger[stage] += 1;
        }
        
        HashMap<Integer, Double> fails = new HashMap<>();
        
        //현재 스테이지 도전자
        double curChallenger = stages.length; 
        
        //실패율 계산
        for (int i = 1; i <= N; i++) {
            curChallenger -= challenger[i - 1];
            fails.put(i, challenger[i] / curChallenger);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        //실패율이 높은 것부터 낮은 순으로 스테이지 넣기
        //실패율이 높은 것(값) 순으로 정렬하기
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(fails.entrySet());
        
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        //그 순서대로 list에 key(stage) 넣기
        for (Map.Entry<Integer, Double> entry : entryList) {
            double curValue = entry.getValue();
            
            if (curValue > 0.0) {
                result.add(entry.getKey());
            }
        }
        
        //실패율이 0인 스테이지 넣기
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                result.add(i);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}