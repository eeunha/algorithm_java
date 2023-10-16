package programmers;

public class AddDigits {
	public int solution(int n) {
		// edge cases
		if (n == 0)
			return 0;

		int answer = 0;
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		return answer;
	}
}
