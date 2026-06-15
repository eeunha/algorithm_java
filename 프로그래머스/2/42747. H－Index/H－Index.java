/*
H idx
논문 n편 중, h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용
-> h의 최대값이 h idx

I: int[] citations
O: int
C: 1 <= n <= 1000
    0 <= h <= 10000
E:

논문 5편 중, [0, 1, 3, 5, 6]
6번 이상 인용된 논문은 1편
5번 이상 인용된 논문은 2편
3번 이상 인용된 논문은 3편 -> return 3

ds: array
algo: sort

citations [0]
발표한 논문이 1개
0번 이상 인용된 논문 > 1개 >> 0 != 1 >> return 0

citations[0, 1]
발표한 논문이 2개
1번 이상 인용된 논문 > 1개 return 1

citations[0, 2]
발표한 논문 수 2개
2번 이상 인용된 논문 > 1개
1번 이상 인용된 논문 > 1개 >> hidx
0번 이상 인용된 논문 > 2개
>> return 1

solution:
citations 정렬하기
뒤에서부터 순회
현재 값이랑 n-idx 같다 > 바로 현재값 리턴
다르다 > 현재 가지고 있는 값이랑 citations[i]와 n-i 중 작은 값이랑 비교해서 큰 값을 가지기
결과 반환

time: O(NlogN)
space: O(1)
*/
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;
        
        Arrays.sort(citations);
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] == n - i) {
                return n - i;
            }
            answer = Math.max(answer, Math.min(citations[i], n - i));
        }
        return answer;        
    }
}