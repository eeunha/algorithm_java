/*
  I: String[]
  O: boolean
  C: 1 <= phone_book.length <= 1000000
     1 <= 전화번호 길이 <= 20
     중복 없음
  E: phone_book.length == 1, return true;

  set 버전.

  time: O(n)
  space: O(n)
*/
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
		
		for (int i = 0; i < phone_book.length; i++) {
			set.add(phone_book[i]);
		}

		for (int i = 0; i < phone_book.length; i++) {
			String curS = phone_book[i];
			for (int j = 1; j < curS.length(); j++) {
				String subS = curS.substring(0, j);
				if (set.contains(subS)) {
					return false;
				}
			}
		}
		return true;
    }
}