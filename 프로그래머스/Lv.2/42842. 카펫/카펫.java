/*
I: int brown, yellow
O: int[]{가로, 세로}
C: 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수
    노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수
    카펫의 가로 길이 >= 세로 길이
E:

갈색 격자의 수: 8 = 3x3
---
- -
---

갈색 격자의 수 구하기
가로 * 세로
(가로 + (세로 - 2)) * 2
(3 + (3 - 2)) * 2 = 

총 카펫의 크기 = 갈색 + 노란색 = 가로 * 세로
            = 10 + 2 = 12 -> 가로 * 세로 => 12가 나오는 경우 찾기
12 = 4 * 3 (최소가 3)

총 카펫의 크기 = 8 + 1 = 9
9 = 3 * 3

갈색 격자 수 구하기
총 카펫의 크기 = 24 + 24 = 48
48 = (48/3 = 16) * 3 -> (16 + (3 - 2)) * 2 = 17*2 = 34 != 24
48 = (48/4 = 12) * 4 -> (12+(4-2))*2 = 14 * 2 = 28 != 24
48 = 48 % 5 != 0
48 = (48/6 = 8) * 6 -> (8+(6-2))*2 = 12 * 2 = 24 == 24 => [8, 6]

갈색 격자 수 = 테두리 쪽 격자 수
노란 격자 수 = 테두리를 제외한 안쪽 격자 수


ds: array
algo: 완전탐색

time: O(N)
space: O(1)
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //1. 총 카펫의 수 구하기
        int totalCarpet = brown + yellow;
        
        //2. 총 카펫의 수를 보고 나올 수 있는 테두리의 경우 구하기
        for (int i = 3; i <= Math.sqrt(totalCarpet); i++) {
            if (totalCarpet % i != 0) { // 테두리 불가능
                continue;
            }
            
            int x = Math.max(i, totalCarpet / i);
            int y = Math.min(i, totalCarpet / i);
            
            //3. 구한 테두리 경우의 수로 brown과 같은지 비교
            if ((x + (y - 2)) * 2 == brown) {
                //4. 같다면 큰 숫자를 먼저 넣어 반환
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}