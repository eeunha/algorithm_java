/*
I: 2차원 정수 배열 arr1, arr2
O: 2차원 정수 배열
C: 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하
    행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수
    곱할 수 있는 배열만 주어집니다.
E:

pseudo code:

time:
space

solution
*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        int[][] answer = new int[r1][c2];
        
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}