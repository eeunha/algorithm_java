/*
도시이름 검색 - 해당 도시와 관련된 맛집 게시물을 데이터베이스에서 읽어 보여주는 서비스
db에서 게시물 가져올때 느림
성능개선
캐시크기에 따른 실행시간 측정 프로그램 작성

I: int cacheSize, String[] cities
O: int 총 실행시간
C: 0 <= cacheSize <= 30 정수
    cities.length <= 100,000 
    cities[i] = 문자열. 영문자로만 구성. 대소문자 구분x
    cities[i].length <= 20
    캐시 교체 알고리즘은 LRU 사용
    cache hit 실행시간 = 1
    cache miss 실행시간 = 5
E: cacheSize == 0 > return cities.length * 5 >> 도시이름 저장소가 없어서 무조건 miss
   cities.length == 0 > return 0 > 도시 자체가 없으니 0초

cache hit
> 이미 존재함 > 이미 있던 도시 지우기 > 리스트의 맨 뒤에 넣기 > 1초

cache miss
> 처음 발견 > 캐시가 비었다면 - 리스트의 맨 뒤에 넣기 > 5초
          > 캐시가 꽉 찼다면 - 맨 앞에 도시 지우기 > 맨 뒤에 넣기 > 5초

ds: arraylist
algo:

solution:
if (cacheSize == 0) return cities.length * 5;
if (cities.length == 0) return 0;

int answer = 0;
ArrayList<String> list = new ArrayList<>();

도시 순회
현재 도시 이름을 소문자로 변경
바꾼 도시 이름이 list에 있는지 확인
이름이 없다 > cache miss
    list.size() == cacheSize > 캐시 꽉 참
        맨 앞 값 제거
        맨 뒤에 현재 도시 넣기
        5초 추가
    else > 빈자리 존재
        맨 뒤에 넣기
        5초 추가
이름이 있다 > cache hit > 
    해당 인덱스 찾기
    해당 인덱스 지우기
    맨 뒤에 add
    1초 추가
시간 반환

time: O(N) N = cities.length
space: O(1)
*/
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // edge case
        if (cacheSize == 0) return cities.length * 5;
        if (cities.length == 0) return 0;
        
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < cities.length; i++) {
            String curCity = cities[i].toLowerCase();
            int curIdx = list.indexOf(curCity);

            if (curIdx == -1) { // cache miss
                if (list.size() < cacheSize) { // 빈자리 있을 때
                    list.add(curCity);
                } else { // 캐시가 꽉 찼을 때
                    list.removeFirst();
                    list.add(curCity);
                }
                answer += 5;
            } else { // cache hit
                list.remove(curIdx);
                list.add(curCity);
                answer++;
            }
        }
        
        return answer;
    }
}