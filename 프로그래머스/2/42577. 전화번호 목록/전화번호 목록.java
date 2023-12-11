/*
  I: String[]
  O: boolean
  C: 1 <= phone_book.length <= 1000000
     1 <= 전화번호 길이 <= 20
     중복 없음
  E: phone_book.length == 1, return true;

  접두어가 있으면 false
  접두어가 없으면 true

  접두어 -> index가 0부터 n까지의 단어.
  a, b가 있을 때 길이가 a < b 라면, a가 b의 접두어일 수 있다.
  접두어가 되려면 길이가 작거나 같아야한다.

  brute force:
  전화번호 목록을 순회한다.
  현재 전화번호를 제외한 나머지 전화번호 목록을 순회한다.
    현재 전화번호보다 길이가 긴 경우, 0부터 현재 전화번호 길이까지 잘라서
    현재 번호과 같은지 확인한다.
    있다면 false를 반환한다.
  없으니 true를 반환한다.

  time: O(n^2)
  space: O(1)

  --

  ds: map
  algo: 순회

  배열을 순회하면서 모든 값을 key로, index를 value로 하여 map에 저장한다.
  다시 배열을 순회하면서 각 전화번호를 처음부터 끝까지 접두어를 만들어 map에 
  key가 있는지 확인한다.
    key가 있다면, value값이 현재 인덱스와 같다면 넘어간다.
        다르다면 접두어가 있으므로 false를 반환한다.
  다 돌아도 없다면 true를 반환한다.

  time: O(n)
  space: O(n)
*/
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], i);
		}

		for (int i = 0; i < phone_book.length; i++) {
			String curS = phone_book[i];
			for (int j = 1; j <= curS.length(); j++) {
				String subS = curS.substring(0, j);
				if (map.containsKey(subS) && map.get(subS) != i) {
					return false;
				}
			}
		}
		return true;
    }
}