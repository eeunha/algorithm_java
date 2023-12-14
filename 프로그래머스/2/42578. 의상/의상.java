import java.util.*;
/*
I: String[][]
O: int 
C: clothes의 각 행은 [의상의 이름, 의상의 종류]
     의상의 수는 1개 이상 30개 이하
     같은 이름을 가진 의상은 존재하지 않습니다.
     clothes의 모든 원소는 문자열
     모든 문자열의 길이는 1 이상 20 이하인 자연수, 알파벳 소문자 또는 '_' 로만
E: 
solution:
map을 만든다.
의상의 종류 - 의상이름
ex) headgear - yellow_hat, green_turban
    eyewear - blue_sunglasses
여기서 조합을 만든다. 고를 수 있는 모든 가지 수 구하기
근데 문제 중복 이름 없다. -> set 써야하는가? 일단은 잘 모르겠어 보류. arraylist 쓰자.
종류별로 최대 1개씩 고를 수 있는 조합 구하기

얼굴 - 2개 => 없다, a, b => 3가지
상의 - 1개 => 없다, a => 2가지
하의 - 1개 => 없다, a => 2가지
겉옷 - 1개 => 없다, a => 2가지
-> 하지만 모두 다 벗을 수는 없다.
=> (a+1)*(b+1)*(c+1)*(d+1)-1

time: O(N)
space: O(N)
*/
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
		
		for (String[] cloth: clothes) {
			map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
		}
		
		int[] arr = new int[map.size()];
		
		int idx = 0;
		
		for (String key : map.keySet()) {
			
			arr[idx] = map.get(key);
			
			idx++;
		}
		
		int answer = 1;

		for (int i = 0; i < arr.length; i++) {
			answer *= (arr[i] + 1);
		}

		return answer - 1;

    }
}