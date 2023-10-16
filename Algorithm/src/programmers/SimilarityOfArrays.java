package programmers;

import java.util.HashSet;
import java.util.Set;

public class SimilarityOfArrays {
	public int solution(String[] s1, String[] s2) {
		int answer = 0;

		Set<String> set = new HashSet<>();
		for (String s : s1) {
			set.add(s);
		}

		for (String s : s2) {
			if (set.contains(s))
				answer++;
		}
		return answer;
	}
}
