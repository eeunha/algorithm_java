/*
I: int[] citations
O: int
C: 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하
    논문별 인용 횟수는 0회 이상 10,000회 이하
E: citations.length == 1 -> return citations[0]

오름차순 정렬

[3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6]
                             ^
발표한 논문 : 5편

h = 1 -> 4편, 남은 1개는 0번 인용
h = 3 -> 3편, 남은 2개는 최대 1번 인용
h = 5 -> 5편 이상 인용된 논문이 2편 => X
=> h = 3 = H-Index

ds: array
algo: sort

time: O(nlogn)
space: O(1)
*/
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}