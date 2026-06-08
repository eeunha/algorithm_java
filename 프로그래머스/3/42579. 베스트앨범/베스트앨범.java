/*
26.06.08
장르별로 가장 많이 재생된 노래 - 두개씩 모아
노래 - 고유 번호로 구분
노래 수록 기준
    1. 속한 노래가 많이 재생된 장르 먼저 수록
    2. 장르 내에서 많이 재생된 노래 먼저 수록
    3. 장르 내에서 재생 횟수가 같은 노래  - 고유번호가 낮은 노래 먼저 수록

I: String[] genres, int[] plays
O: int[] 고유 번호 순서대로
C: genres[i] - 고유번호가 i인 노래의 장르
   plays[i] - 고유번호가 i인 노래가 재생된 횟수
   genres.length == plays.length
   1 <= genres.length, plays.length <= 10,000
   genres < 100
   장르에 속한 곡이 하나라면 하나의 곡만 선택
   모든 장르는 재생된 횟수가 다르다
E: genres.length == 1 && playes.length == 1 > return new int[]{0};

genres {classic, pop, classic, classic, pop}
plays  {500,     600, 150,     800,     2500}

1차 맵 (재생수, 고유 번호(idx))
classic - [500, 0] [150, 2] [800, 3]
pop - [600, 1] [2500, 4]

1. 재생 많이 된 장르부터
classic = 500 + 150 + 800 = 1450
pop = 600 + 2500 = 3100
>> pop classic 순서

2. 재생 많이 된 곡부터
pop - [2500, 4] [600, 1]
classic = [800, 3] [500, 0] [150, 2]

3. 곡 수 같나? 아님.
4. 두 장르 다 2곡 이상 존재 > 장르별 두개씩 자르기
return [4, 1, 3, 0]

ds: map, arraylist
algo: sort

solution:

//edge case
genres.length == 1 > return new int[]{0};

장르별 재생 수 담을 맵 생성
장르별 곡과 재생수를 담을 맵 생성

genres 순회
  장르별 재생수 맵 세팅
  통합 맵 세팅
  
장르 맵 순회하면서 장르 이름을 넣은 리스트 만들기
장르 재생수 기준으로 내림차순 정렬

결과 리스트 생성

정렬된 장르 순회
  해당 장르 안의 곡을 재생수 기준 내림차순 정렬
  최대 2곡 뽑아서 결과 리스트에 넣기

결과 리스트를 배열로 바꾸어 반환

time: O(NlogN)
space: O(N)
*/
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // edge case
        if (genres.length == 1) return new int[]{0};
        
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, ArrayList<Music>> totalMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String curGenre = genres[i];
            int curPlay = plays[i];
            
            // 장르별 재생수 합산 맵 세팅
            genreMap.put(curGenre, genreMap.getOrDefault(curGenre, 0) + curPlay);

            // 장르별 곡 목록 맵 세팅
            ArrayList<Music> curList = totalMap.getOrDefault(curGenre, new ArrayList<>());
            curList.add(new Music(i, curPlay));
            totalMap.put(curGenre, curList);
        }
        
        // 장르 이름을 리스트로 만들기
        List<String> genreList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genreMap.entrySet()) {
            genreList.add(entry.getKey());
        } 
        
        // 장르 이름들을 총 재생수 기준으로 정렬
        Collections.sort(genreList, (a, b) -> genreMap.get(b) - genreMap.get(a));
                
        // 결과 리스트 생성
        ArrayList<Integer> answerList = new ArrayList<>();
        
        // 정렬된 장르 순서대로 순회
        for (String genre : genreList) {
            ArrayList<Music> musics = totalMap.get(genre);
            
            // 해당 장르 안의 곡들을 play 기준 내림차순 정렬
            Collections.sort(musics, (a, b) -> {
                if (a.play == b.play) {
                    return a.id - b.id; // 재생수 같으면 고유번호 오름차순
                }
                return b.play - a.play; // 다르면 재생수 내림차순
            });
            
            // 최대 2개 뽑기
            for (int i = 0; i < 2 && i < musics.size(); i++) {
                answerList.add(musics.get(i).id);
            }   
        }
        
        // answerList를 array로 바꾸어 반환
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Music {
    int id;
    int play;
    
    public Music(int id, int play) {
        this.id = id;
        this.play = play;
    }
}