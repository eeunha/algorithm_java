package programmers;

public class CreateMaximumValue1 {
	public int solution(int[] numbers) {
		// edge cases
		if (numbers.length == 2)
			return numbers[0] * numbers[1];

		int n1st = (numbers[0] > numbers[1]) ? numbers[0] : numbers[1];
		int n2nd = (numbers[0] > numbers[1]) ? numbers[1] : numbers[0];

		// 가장 큰 두 수를 고르기
		for (int i = 2; i < numbers.length; i++) {
			if (n1st < numbers[i]) {
				n2nd = n1st;
				n1st = numbers[i];
			} else if (n2nd < numbers[i]) {
				n2nd = numbers[i];
			}
		}

		return n1st * n2nd;
	}

}
