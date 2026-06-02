/*
    * 26.06.02
    * 전화번호 목록 (프로그래머스)
    *
    * 전화번호부에 적힌 전화번호 중 한 번호가 다른 번호의 접두어인 경우가 있는지 확인
    *
    * I: String[] phone_book
    * O: boolean
    * C: 1 <= phone_book.length <= 1,000,000 / 1 <= 전화번호 길이 <= 20 (중복 없음)
    * E: phone_book.length == 1 > return true (전화번호가 하나라면 다른 번호의 접두어일 수 없음)
    *
    * 한 번호(a)가 다른 번호(b)의 접두어인가? > 한 번호 그대로가 다른 번호의 맨 앞부터 그대로 있는가?
    * 근데 중복 없으니까 a.length() < b.length() 일 경우만 확인 가능.
    *
    * 1.
    * 만약 set에다가 phone_book 안의 번호 다 넣기
    * phone_book 순회하면서
    *   set 순회
    *     현재 번호 길이 >= set 번호 길이 >> 넘어가
    *     현재 번호 길이 < set 번호 길이
    *       set 번호.startsWith(현재번호)  true > return false >> 여기 시간복잡도는 모르겠어. 추가로 들것같긴해
    * return true
    * -> 하지만 O(N^2) 라면 100만 * 100만 = 1조 라 안됨. O(N)이나 O(NlogN)으로 작성하기
    *
    * 2. (solutionWithHash로 구현)
    * substring으로 접두어를 잘라서 셋에서 찾으면?
    * 그럼 아예 같은 경우 어떻게 구분? > (3 작성 후 추가) 접두어 자를때 원 번호는 찾지 않기. 원 길이-1 까지만 접두어 만들기.
    *
    * 3. (solutionWithSort로 구현)
    * 배열을 정렬한다
    * 배열 순회
    *   바로 뒷 값이 현재 값으로 시작한다면 return false
    * return true
    *
    * ds: array / set
    * algo: sort / hash
    * */
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        return solutionWithHash(phone_book); // 해시 풀이 (O(N))
        // return solutionWithSort(phone_book); // 정렬 풀이 (O(N log N))
    }

	// 풀이 3 기반: 정렬(Sort) 방식
    // time: O(NlogN) / space: O(1)
    public boolean solutionWithSort(String[] phone_book) {

        // edge case
        if (phone_book.length == 1) return true;

        Arrays.sort(phone_book);

        for (int i = 0 ; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }

    // 풀이 2 기반: 해시(Hash) 정공법
    // time: O(N) / space: O(N)
    public boolean solutionWithHash(String[] phone_book) {

        // edge case
        if (phone_book.length == 1) return true;

        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phone : phone_book) {
            for (int i = 0; i < phone.length() - 1; i++) {
                if (set.contains(phone.substring(0, i + 1))) {
                    return false;
                }
            }
        }
		
        return true;
    }
}