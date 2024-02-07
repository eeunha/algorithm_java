/*
time: O(n), n은 triangle의 원소 수
space: O(1)
*/
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        
        //edge cases
        if (length == 1) return triangle[0][0];
        
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int curNumber = triangle[i][j];
                
                if (j == 0) {
                    //오른쪽 값만 가져오기
                    triangle[i][j] += triangle[i - 1][j];
                    
                } else if (j == triangle[i].length - 1) {
                    //왼쪽 값만 가져오기
                    triangle[i][j] += triangle[i - 1][j - 1];
                    
                } else {
                    //둘 다 가져오기
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        
        for (int i = 0; i < triangle[length - 1].length; i++) {
            answer = Math.max(answer, triangle[length - 1][i]);
        }
        
        return answer;
    }
}