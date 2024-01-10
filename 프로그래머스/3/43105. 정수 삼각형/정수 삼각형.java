/*
I: int[][]
O: int
C: 삼각형의 높이는 1 이상 500 이하
    삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수
E: 삼각형의 높이 == 1 -> return triangle[0][0];

ds: 2 dimensional array
algo: DP

[7]
[3, 8]
[8, 1, 0]
[2, 7, 4, 4]
[4, 5, 2, 6, 5]

위에서부터 아래로 내려가면서 숫자를 더해간다.
숫자가 겹치는 경우 큰 숫자를 저장한다.

현재 위치를 (i, j)라고 할 때,
triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);

맨 마지막줄을 순회하면서 가장 큰 값을 찾아 반환하면 된다.

time: O(N), N 은 triangle[][] 원소의 개수
space: O(1)
*/
class Solution {
    public int solution(int[][] triangle) {
        //edge cases
        if (triangle.length == 1 && triangle[0].length == 1) return triangle[0][0];
                                           
        int answer = 0;
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }                                   
                                           
        for (int n : triangle[triangle.length - 1]) {
            answer = Math.max(answer, n);
        }
                                           
        return answer;
    }
}