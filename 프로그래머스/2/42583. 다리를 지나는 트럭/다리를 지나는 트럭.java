/*
I: int bridge_length 다리에 올라갈 수 있는 트럭 수, int weight 다리가 견딜 수 있는 무게, int[] truck_weights 트럭 무게 배열
O: int 다리를 다 건너는데 드는 최소 시간(초)
C: bridge_length는 1 이상 10,000 이하
    weight는 1 이상 10,000 이하
    truck_weights의 길이는 1 이상 10,000 이하
    모든 트럭의 무게는 1 이상 weight 이하
E: truck_weights.length == 1, return bridge_length + 1

트럭 여러대가 일차선 다리를 정해진 순으로 건너기
모든 트럭이 다리를 건너는데 드는 최소 시간(초)
다리에는 최대 bridge_length 대 올라갈 수 있고, weight 이하 무게를 견딜 수 있다.
(단, 다리를 완전히 올라야만 무게 계산 가능)

트럭 2개 가능, 무게는 10kg 가능 => 7, 4, 5, 6 트럭이 순서대로 최단시간 안에 다리를 건너려면


ds: queue
algo:

bridge_length만큼 큐 생성하기 -> 불가. 매번 물어보는 작업 필요
트럭 무게를 재는 변수 필요
초 수 변수 필요 -> answer 변수

트럭 하나가 다리를 건너는데 걸리는 시간 = bridge_length + 1 초

queue.add(트럭1), answer++, curWeight += truck_weights[i]

새로운 트럭을 하나 더 보내려면,
0. answer++ (시간 증가)
1. 큐의 크기 = 다리의 길이를 확인 -> 도착한 차 빼내기
-> 다리의 길이가 아직 남았다면, 그대로 올릴 수 있다.
-> 가득 찼다면, queue.poll(), curWeight에서 트럭 무게 빼기. 그다음 2로 이동
2. 다리의 무게 weight를 확인
-> curWeight + truck무게 <= weight -> queue.add(트럭2)
-> 초과한다면, 현재 트럭을 먼저 다리에 건너기

time: O(N)
space: O(N)
*/
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // edge cases
		if (truck_weights.length == 1)
			return bridge_length + 1;

		int time = 0;
		ArrayList<Integer> list = new ArrayList<>();

		int curBridgeIdx = 0;
		int curTruckIdx = 0;
		int curWeight = 0;

		while (true) {
			// 초 증가
			time++;

			// 트럭 도착
			// 도착한 트럭이 있는가? > 현재 무게에서 제거
			if (curBridgeIdx >= bridge_length && list.get(curBridgeIdx - bridge_length) != 0) {
				curWeight -= list.get(curBridgeIdx - bridge_length);
			}

			// 보낼 트럭이 있는가?
			if (curTruckIdx >= truck_weights.length) { // 트럭을 모두 다 보낸 경우
				list.add(0);
				
				// 다리에 트럭이 없는 경우
				if (curWeight == 0) {
					break;
				} else {
					curBridgeIdx++;
					continue;
				}
			}

			// 현재 넣을 트럭
			int curTruck = truck_weights[curTruckIdx];

			// 넣을 트럭과 존재하는 트럭 무게를 비교하여 초과하는지 확인하기
			if (curWeight > 0 && curWeight + curTruck > weight) { // 트럭 존재하지만 초과하는 경우

				list.add(0); // 널값 넣기

			} else { // 트럭 미존재 또는 트럭이 존재하나 더 넣을 수 있음
				// 트럭 보내기
				list.add(curTruck); // 다리에 트럭 올리기
				curWeight += curTruck; // 현재 트럭 무게 추가하기
				curTruckIdx++; // 트럭 인덱스 증가
			}

			curBridgeIdx++; // 다리 인덱스 증가
		}

		return time;
    }
}