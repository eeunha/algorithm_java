import java.util.*;
/*
 23.11.24
 I: int[] numbers
 O: int result
 C: -10,000 ≤ numbers의 원소 ≤ 10,000
 	2 ≤ numbers 의 길이 ≤ 100
 E: numbers.length == 2 -> return numbers[0] * numbers[1]
 
 numbers 정렬하기
 
 1. 최대값이 양수값인가?
 	음수와 양수가 2개이상씩 있는가 확인
 	음수값이 2개이상인 경우 -> 가장 작은 음수값 2개 곱하기
 	양수값이 2개 이상인 경우 -> 가장 큰 양수값 2개 곱하기
 
 2. 최대값이 음수값인가?
 	가장 큰 음수값 * 가장 작은 양수값

 numbers[0] * numbers[1], numbers[numbers.length - 2] * numbers[numbers.length - 1], 중간값 
 
 time: O(NlogN), N = numbers.length
 space: O(1)
*/
class Solution {
    public int solution(int[] numbers) {
        // edge cases
		if (numbers.length == 2)
			return numbers[0] * numbers[1];

		int answer = 0;

		Arrays.sort(numbers);

		int a = numbers[0] * numbers[1];
		int b = numbers[numbers.length - 2] * numbers[numbers.length - 1];

		// 모두 음수인 경우
		if (numbers[0] < 0 && numbers[numbers.length - 1] <= 0) {
			return a;
		}

		// 모두 양수인 경우
		if (numbers[0] >= 0 && numbers[numbers.length - 1] > 0) {
			return b;
		}

		int index = -1;
		
		// 음수 양수 다 있을 경우
		// 음수->양수 변경되는 곳의 인덱스 찾기
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= 0) {
				index = i;
				break;
			}
		}
		
		int c = numbers[index - 1] * numbers[index];

		return Math.max(Math.max(a, b), c);
    }
}
