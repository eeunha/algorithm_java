import java.util.*;

/*
23.11.22

I: int[] progresses -> 작업의 진도, int[] speeds -> 개발속도
O: int[]
C: 작업의 개수(progresses, speeds배열의 길이)는 100개 이하
    작업 진도는 100 미만의 자연수
    작업 속도는 100 이하의 자연수
    배포는 하루에 한 번만, 하루의 끝에 이루어진다.
E: progresses.length == 1 -> return new int[]{1};

각 기능의 진도가 100%일 때 서비스에 반영 가능.
뒤의 기능이 앞의 기능보다 먼저 개발될 수 있음.
뒤에 기능은 앞의 기능이 배포될 때 같이 배포됨. -> 앞에가 덜 끝나면 기다려야한다.

각 배포마다 몇 개의 기능이 배포되는지 return

ArrayList로 만들다가 int[]에 넣기

brute force:
예시
[93, 30, 55]  [1, 30, 5]
1일차 [94, 60, 60]  
2일차 [95, 90, 65]
3일차 [96, 120, 70] -> progress[1] 완료, 대기
4일차 [97, 120, 75]
5일차 [98, 120, 80]
6일차 [99, 120, 85]
7일차 [100, 120, 90] -> progress[0], [1] 완료 -> 결과배열에 2 넣기
8일차 [100, 120, 95]
9일차 [100, 120, 100] -> progress[2] 완료 -> 결과배열에 1 넣기
result [2, 1]

ds: 큐
algo: 순회

큐에 progresses 넣기
[93, 30, 55]
큐가 빌 때까지 각 speeds 더하기
맨 앞의 값이 100 이상이라면 빼기 -> 100 미만 값이 나올 때까지 반복
-> 횟수 세기
100 미만 값이 나왔다면 빠진 값의 수를 결과 배열에 넣기


time:
space: O(n), n = progresses.length
*/
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // edge cases
		if (progresses.length == 1)
			return new int[] { 1 };

		int[] answer = {};

		ArrayList<Integer> list = new ArrayList<>();

		// 배포할 시작 인덱스
		int front = 0;

		// 배포된 기능 개수
		int count = 0;

		while (front < progresses.length) {
			
			// 매일 speeds만큼 더한다.
			for (int i = front; i < progresses.length; i++) {
				progresses[i] += speeds[i];
			}

			// 더했을 때 progresses[front]가 100 이상인가?
			while (front < progresses.length && progresses[front] >= 100) {
				// 이상이라면 - 배포한다. 개수를 센다
				count++;
				front++;
			}

			if (count > 0) {
				list.add(count);
				count = 0;
			}
		}

		answer = list.stream().mapToInt(i -> i).toArray();

		return answer;
    }
}
