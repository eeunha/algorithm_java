import java.util.*;
/*
time: O(NlogN)
space: O(N)
*/
class Solution {
    public int solution(int[] priorities, int location) {
		int answer = 0; // 빠져나간 개수
		Queue<Integer> queue = new LinkedList<Integer>();

		int curMaxIdx = priorities.length - 1; // 가장 큰 우선순위가 있는 인덱스

		for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]);
		}

		Arrays.sort(priorities); // 우선순위를 정렬함

		while (curMaxIdx >= 0) {
			if (queue.peek() == priorities[curMaxIdx]) {
				// 꺼내기
				queue.poll();
				answer++;

				if (location == 0) {// 내가 찾는 값인 경우
					break;
				}

				location--;
				curMaxIdx--;

			} else {
				// 다음 수로 이동하기
				int n = queue.poll();
				queue.add(n);

				if (location == 0) { // 내가 찾는 값인 경우
					location = queue.size() - 1;
				} else {
					location--;
				}
			}
		}

		return answer;
	}
}
