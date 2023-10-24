/*
I: int[] arr, int[][] queries
O: int[]
C: 1 ≤ arr의 길이 ≤ 1,000
        0 ≤ arr의 원소 ≤ 1,000,000
    1 ≤ queries의 길이 ≤ 1,000
        0 ≤ s ≤ e < arr의 길이
        0 ≤ k ≤ 1,000,000
E:

각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해
k보다 크면서 가장 작은 arr[i]를 찾습니다.

arr[] = 0,1,2,4,3
queries[][] = [0,4,2],[0,3,2],[0,2,2]
result[] = 3,4,-1

[0,4,2]
0 <= i <= 4 -> i = 0~4, k=2 -> i=3,4 -> arr[3]=4, arr[4]=3 => 3

[0,3,2]
0 <= i <= 3 -> i = 0~3, k=2 -> i=3 -> arr[3]=4 => 4

[0,2,2]
0 <= i <= 2 -> i=0~2, k=2 => -1


[0,3,4]
0~3 < = 4
if (e <= k) -1
if (queries[j][1] <= queries[j][2]) -> -1

=> result[].length == queries.length

solution:

time:
space:
*/
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = queries[i][2];
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                int n = arr[j];
                if (n > k) {
                    min = Math.min(min, n);
                }
            }
            answer[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        
        return answer;
    }
}