/*
I: int bridge_length, int weight, int[] truck_weight
O: int
C: 1 <= bridge_length <= 10000
    1 <= weight <= 10000
    1 <= truck_weights.length <= 10000
    1 <= truck weight <= weight
    다리에는 최대 bridge_length 대의 트럭 올라갈 수 있음
    다리 하중 <= weight
    다리에 완전히 오르지 않은 트럭의 무게는 무시
E: truck_weights.length == 1 > return bridge_length + 1(진입일);

ds: queue
algo:

현재 다리 하중, 트럭 idx, 일수, deque 생성

다리 길이만큼 덱에 -1 넣기

트럭 개수만큼 while
일수 증가
덱에서 poll
poll 값이 -1이 아닌 경우에만 현재 다리 하중에서 poll 값 빼기

다리 하중 - 현재 하중 >= 현재 트럭 하중
    현재 트럭 무게를 add
    현재 하중 + 현재 트럭 무게
    idx++
아닌 경우
    -1 add

일수 + 다리의 길이 반환

time: O(W) bridge_length * truck_weights.length
space: O(N) N = bridge_length
*/
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // edge case
        if (truck_weights.length == 1) {
             return bridge_length + 1;
        }
        
        int answer = 0;
        int idx = 0;
        int curWeight = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            dq.add(-1);
        }
        
        while (idx < truck_weights.length) {
            answer++;
            
            int out = dq.poll();
            
            if (out != -1) {
                curWeight -= out;
            }
            
            int curTruckWeight = truck_weights[idx];
            
            if (weight - curWeight >= curTruckWeight) {
                dq.add(curTruckWeight);
                curWeight += curTruckWeight;
                idx++;
            } else {
                dq.add(-1);
            }
        }
        
        return answer + bridge_length;
    }
}
