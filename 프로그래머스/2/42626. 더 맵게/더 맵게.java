/*
I: int[] scoville, int k
O: int 섞어야 하는 최소 횟수
C: scoville의 길이는 2 이상 1,000,000 이하
    K는 0 이상 1,000,000,000 이하
    scoville의 원소는 각각 0 이상 1,000,000 이하
    scoville의 원소는 각각 0 이상 1,000,000 이하
E: 모든 스코빌이 0인 경우 -> -1 반환
    모든 스코빌이 K 이상일 경우 -> 0 반환

스코빌 지수를 K 이상으로 만들고 싶다.
-> 스코빌 지수가 가장 낮은 두 개의 음식을 섞는다.
=> 섞은 음식의 스코빌 지수 = 가장 안매운 음식의 스코빌 지수 + (두 번째로 안매운 음식의 스코빌 지수 * 2)

모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞는다.


scoville에는 정렬되지 않았다.

최소 힙을 만들어서 루트 + 루트의 왼쪽 자식을 섞어 새로운 음식으로 만든다.

최소 힙의 루트가 k이상일 때까지 반복한다.

ds: min heap -> Priority Queue
algorithm:

time: O(nlogn)
space: O(n)
*/
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int firstMinScoville = 0;
        int secondMinScoville = 0;
        int newScoville = 0;
        
        int sum = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
            sum += scoville[i];
        }
        
        //edge cases
        if (sum == 0) return -1;
        if (heap.peek() >= K) return 0;
        
        while (heap.peek() < K && heap.size() >= 2) {
            firstMinScoville = heap.poll();
            secondMinScoville = heap.poll();
            
            newScoville = firstMinScoville + (secondMinScoville * 2);
            
            heap.add(newScoville);
            
            answer++;
        }
        
        return (heap.size() == 1 && heap.peek() < K) ? -1 : answer;
    }
}