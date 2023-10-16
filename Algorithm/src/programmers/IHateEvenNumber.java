package programmers;

import java.util.Arrays;

public class IHateEvenNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(10)));
	}

	public static int[] solution(int n) {
		int[] answer = new int[(int) ((n + 1) / 2)];

		int index = 0;

		for (int i = 1; i <= n; i += 2) {
			answer[index] = i;
			index++;
		}
		return answer;
	}
}
