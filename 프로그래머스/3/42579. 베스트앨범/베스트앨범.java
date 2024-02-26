/*
I: String[] genres, int[] plays
O: int[] 노래의 고유번호 배열
C: genres[i]는 고유번호가 i인 노래의 장르
    plays[i]는 고유번호가 i인 노래가 재생된 횟수
    genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하
    장르 종류는 100개 미만
    장르에 속한 곡이 하나라면, 하나의 곡만 선택
    모든 장르는 재생된 횟수가 다릅니다
E:

장르별로, 가장 많이 재생된 노래 두 개씩 찾기
노래 - 고유번호로 구분
노래 수록 기준 
- 1. 속한 노래가 많이 재생된 장르 수록
- 2. 장르 내에서 많이 재생된 노래 수록
- 3. 같은 장르의 재생 횟수가 같은 노래는 고유번호가 낮은 노래를 먼저 수록

classic - 500 + 150 + 800  = 1450
pop - 600 + 2500 = 3100

pop - classic 순서

classic - [0, 500], [2, 150], [3, 800]
pop - [1, 600], [4, 2500]

ds: map
algo:

time:
space:
*/
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
 
        HashMap<String, Integer> num = new HashMap<>(); // 장르별 총 개수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 노래 및 재생횟수
        for(int i = 0; i < plays.length; i++) {
            if(!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }
 
        List<String> keySet = new ArrayList(num.keySet());
        Collections.sort(keySet, (s1, s2) -> num.get(s2) - (num.get(s1)));
 
        for(String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
 
            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));
 
            answer.add(genre_key.get(0));
            if(genre_key.size() > 1)
                answer.add(genre_key.get(1));
        }
 
        return answer.stream().mapToInt(i -> i).toArray();
    }
}