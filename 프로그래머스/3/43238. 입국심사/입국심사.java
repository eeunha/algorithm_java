/*
I: int n 입국심사를 기다리는 사람 수, int[] times 각 심사관이 심사하는데 걸리는 시간
O: long 모든 사람을 심사하는데 걸리는 최소 시간
C: 처음에 모든 심사대는 비어있다. 
    한 심사대에는 한 명만 심사 가능
    가장 앞에 서 있는 사람이 빈 심사대에서 심사 가능. 근데 더 빨리 끝나는 곳이 있다면 기다렸다가 심사받아도 됨.
    입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하
    각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하
    심사관은 1명 이상 100,000명 이하
E: 심사관이 1명이라면 -> return n * times[0]
    n == 1 -> return times[]의 최소값

0분 -> times.length = 2만큼 심사 시작 -> 남은 사람 수 = 4
가장 짧은 시간 7분 -> 1명 완료, 새 사람 심사 시작 -> 남은 사람 수 = 3
10분 -> 1명 완료, 새 사람 심사 시작 -> 남은 사람 수 = 2
14분 -> 1명 완료, 새 사람 심사 시작 -> 남은 사람 수 = 1
20분 -> 1명 완료, 새 사람 심사 (7분짜리가 1분 뒤에 종료) 대기
21분 -> 1명 완료, 새 사람 심사 시작 -> 남은 사람 수 = 0

ds: 배열
algo: 이분 탐색

time: O(n log n)
space: O(1)
*/
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
       
        Arrays.sort(times);
        
        //edge cases
        if (times.length == 1) return (long) times[0] * n;
        else if (n == 1) {
            return (long) times[0];
        }
        
        long answer = 0;
        long left = 0;
        long right = (long) times[times.length - 1] * n; // 모든 사람이 가장 느리게 심사받음 
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;
            
            for (int i = 0; i < times.length; i++) {
                complete += mid / times[i];
            }
            
            if (complete < n) { // 해당 시간 내에는 모든 사람이 심사받을 수 없다.
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid; // 모두 심사를 받았으나 시간이 짧은 경우가 있을 수 있다.
            }
        }
        
        return answer;
    }
}