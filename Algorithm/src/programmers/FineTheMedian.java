package programmers;

import java.util.Arrays;

public class FineTheMedian {
	public int solution(int[] array) {
		Arrays.sort(array);
		return array[(int) (array.length / 2)];
	}
}
