import java.util.*;
/*
I:
O:
C:
E:

모두 음수인 경우


모두 양수인 경우

둘다 있는 경우
1. 가장 작은 음수 2개 곱한 값
2. 가장 큰 양수 2개 곱한 값
3. 가장 큰 음수 * 가장 작은 양수
배교

time:
space:
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