package programmers;

public class Protractor {
	public int solution(int angle) {
		int answer = 0;
		if (angle == 180) {
			return 4;
		} else if (angle > 90) {
			return 3;
		} else if (angle == 90) {
			return 2;
		} else {
			return 1;
		}
	}
}
