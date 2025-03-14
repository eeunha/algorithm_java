/*
일차원 배열 만들기

I: int n, int left, int right
O: int[]
C: 1 ≤ n ≤ 107
    0 ≤ left ≤ right < n2
    right - left < 105
E:

n = 3
1 2 3
2 2 3
3 3 3

arr = 1 2 3 2 2 3 3 3 3 


n = 4
1 2 3 4
2 2 3 4
3 3 3 4
4 4 4 4

left = 7 -> 7 % 4 = 3 -> 2행 4열 > 행 = 몫 + 1, 열 = 나머지 + 1
right = 14 -> 14 % 4 = 2 -> 4행 3열 > 
arr = 1 2 3 4 2 2 3 4 3 3 3 4 4 4 4 4
result = 4 3 3 3 4 4 4 4

left % n

pseudo:

time:
space:

solution:
*/
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        int idx = 0;
        
        for (long i = left; i <= right; i++) {
            int row = (int)(i / n) + 1;
            int col = (int)(i % n) + 1;
            int value = 0;
            
            if (row < col) {
                value = col <= row ? row : col;
            } else if (row >= col || row == n) {
                value = row;
            } 
            
            answer[idx] = value;
            idx++;
        }
        
        return answer;
    }
}