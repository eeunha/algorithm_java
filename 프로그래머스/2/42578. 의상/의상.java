import java.util.*;
/*
    * 26.06.02
    * 의상
    *
    * I: String[][] clothes 가지고 있는 의상
    * O: int 서로 다른 옷의 조합의 수
    * C: clothes의 각 행 - [의상의 이름, 의상의 종류]
    *    1 <= 코니가 가진 의상의 수 <= 30
    *    같은 이름의 의상은 없음
    *    clothes의 모든 원소는 문자열
    *    1 <= 모든 문자열의 길이 <= 20 자연수. 알파벳 소문자 또는 _
    *    각 종류별로 최대 1가지 의상만 착용 가능
    *    착용한 의상 일부가 겹쳐도 다른 의상이 안겹치거나 의상 추가 착용시 가능
    *    최소 하루에 한개는 입는다
    * E: 코니가 가진 의상의 수 == 1 > return 1
    *
    * ds: map
    * algo: hash
    *
    * solution:
    *   일단 map에 의상 종류 별 개수를 key, value로 넣기
    *   그걸로 조합 구하기
    *     = (개수 + 1) * (개수 + 1) * ... * (개수 + 1) - 1(모두 안입는 경우)
    *
    * time: O(N) N = clothes.length
    * space: O(N)
    * */
class Solution {
    public int solution(String[][] clothes) {
        
		// edge case
        if (clothes.length == 1) return 1;

        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }
}