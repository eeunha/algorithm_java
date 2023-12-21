import java.util.*;

/*
23.12.21

I: int[] progresses -> 작업의 진도, int[] speeds -> 개발속도
O: int[]
C: 작업의 개수(progresses, speeds배열의 길이)는 100개 이하
    작업 진도는 100 미만의 자연수
    작업 속도는 100 이하의 자연수
    배포는 하루에 한 번만, 하루의 끝에 이루어진다.
E: progresses.length == 1 -> return new int[]{1};

time: O(nm), n = progresses.length, m = 작업일
space: O(n), n = progresses.length
*/
class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {

        //edge case
        if (progresses.length == 1) return new int[]{1};
        
		ArrayList<Integer> arr = new ArrayList<>();
		int count = 0;
		int idx = 0;

		while (idx < progresses.length) {

			count = 0;

			for (int i = idx; i < speeds.length; i++) {

				progresses[i] += speeds[i];
			}

			for (int i = idx; i < progresses.length; i++) {

				if (progresses[i] >= 100) {

					count++;
					idx++;

				} else {

					if (count > 0) {
						arr.add(count);
					}

					break;
				}
			}
		}

		if (count > 0) {

			arr.add(count);
		}

		return arr.stream().mapToInt(i -> i).toArray();
	}
}