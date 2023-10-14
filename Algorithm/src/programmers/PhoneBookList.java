package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBookList {
	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };
//		String[] phone_book = { "123", "456", "789" };

		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phoneBook) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook[i].length(); j++) {
                if (map.containsKey(phoneBook[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }
	
	
	// 이전의 풀이
	public static boolean solution3(String[] phone_book) {
		// edge case
		if (phone_book.length <= 1)
			return true;

		// map 생성
		HashMap<String, Integer> map = new HashMap<>();

		// 전체 map 생성
		for (String s : phone_book) {
			for (int i = 1; i <= s.length(); i++) {
				String subStr = s.substring(0, i);
				map.put(subStr, map.getOrDefault(subStr, 0) + 1);
			}
		}

		// 검사하기
		for (int i = 0; i < phone_book.length; i++) {
			if (isExist(i, phone_book, map))
				return false;
		}

		return true;
	}

	private static boolean isExist(int index, String[] phone_book, HashMap<String, Integer> map) {
		String number = phone_book[index];
		
		HashMap<String, Integer> curMap = new HashMap<>(map);
		
//		System.out.println(curMap);

		// 전체 맵에서 현재 문자의 접두어 빼기
		for (int i = 1; i <= number.length(); i++) {
			String subStr = number.substring(0, i);
			if (curMap.get(subStr) == 1) {
				curMap.remove(subStr);
			} else {
				curMap.replace(subStr, curMap.get(subStr) - 1);
			}
		}
		
//		System.out.println("map: " + map);

		// 변경된 맵에서 현재 값이 문자열로 있는지 확인하기
		return (curMap.containsKey(number)) ? true : false;
	}

	public static boolean solution2(String[] phone_book) {
		// edge case
		if (phone_book.length <= 1)
			return true;

		for (int i = 0; i < phone_book.length; i++) {
			// 1. 전체 셋을 만들고 현재 값을 접두어로 만든 값을 셋에서 뺀다
			// -> 이미 중복제거 처리가 되었기 때문에, 현재 내 값에서 나온 것인지, 다른 값에서 나온 것인지 확인 불가.
			// => 안된다.

			// 2. 매번 셋을 새로 만든다.
			// 현재 값을 제외한 나머지 값으로 set 만들기
			// 만들어진 셋에서 현재 값이 존재하는지 확인
			// 존재하면 false, 없다면 true
			// 존재한다면 바로 return false를 하면 되지만, 없는 경우는 모든 값을 확인해야 한다.
			// -> 다 순회한 다음에도 없을 때 true를 반환한다.

			if (isExist3(i, phone_book)) {
				return false;
			}
		}
		return true;
	}

	// map으로 개수까지 넣어보자
	private static boolean isExist3(int index, String[] phone_book) {
		// map 생성
		HashSet<String> set = new HashSet<>();

		String number = phone_book[index];

		// 현재 값을 제거한 map을 만든다.
		for (int i = 0; i < phone_book.length; i++) {
			if (i == index || (number.length() > phone_book[i].length()))
				continue;

			String str = phone_book[i];

			for (int j = 1; j <= number.length(); j++) {
				set.add(str.substring(0, j));
			}
		}
		return (set.contains(number)) ? true : false;
	}

	private static boolean isExist2(int index, String[] phone_book) {
		// set 생성
		HashSet<String> set = new HashSet<>();

		String number = phone_book[index];

		// 현재 값을 제거한 셋을 만든다.
		for (int i = 0; i < phone_book.length; i++) {
			if (i == index || (number.length() > phone_book[i].length()))
				continue;

			String str = phone_book[i];

			for (int j = 1; j <= number.length(); j++) {
				set.add(str.substring(0, j));
			}
		}
		return (set.contains(number)) ? true : false;
	}

//	private static boolean isExist1(int index, String[] phone_book) {
//		// set 생성
//		HashSet<String> set = new HashSet<>();
//
//		// 현재 값을 제거한 셋을 만든다.
//		for (int i = 0; i < phone_book.length; i++) {
//			if (i == index)
//				continue; // 현재 값이 같은 경우 다음으로 넘어간다.
//
//			String str = phone_book[i];
//
//			for (int j = 1; j <= str.length(); j++) {
//				set.add(str.substring(0, j));
//			}
//		}
//
//		// 만들어진 셋에서 현재 값이 존재하는지 확인
//		if (set.contains(phone_book[index])) {
//			return true;
//		}
//
//		return false;
//	}

	// 자신과 같은 수도 확인하게 되어서 문제가 발생한다.
	public static boolean solution1(String[] phone_book) {
		if (phone_book.length <= 1)
			return true;

		// set 생성
		HashSet<String> set = new HashSet<>();

		for (String s : phone_book) {
			for (int i = 1; i <= s.length(); i++) {
				set.add(s.substring(0, i)); // 자리수 1씩 증가
			}
		}

		System.out.println(set);

		for (String s : phone_book) {
			if (set.contains(s))
				return false;
		}
		return true;
	}
}
