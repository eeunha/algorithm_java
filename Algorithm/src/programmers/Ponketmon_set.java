package programmers;

import java.util.HashMap;

public class Ponketmon_set {
	public int solution(int[] nums) {
		// edge cases
		if (nums.length == 2)
			return 1;

		// set에 넣기
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// set 크기 확인하기
		if (map.size() >= nums.length / 2) {
			return nums.length / 2;
		}

		return map.size();
	}
}
