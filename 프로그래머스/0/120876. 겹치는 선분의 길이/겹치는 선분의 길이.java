import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        boolean[] arr = new boolean[200];

        Arrays.sort(lines, (a, b) -> a[0] - b[0]);
        
        if (lines[0][1] > lines[1][0]) {
            for (int i = lines[1][0]; i < Math.min(lines[0][1], lines[1][1]); i++) {
                arr[i + 100] = true;
            }
        }
        if (lines[0][1] > lines[2][0]) {
            for (int i = lines[2][0]; i < Math.min(lines[0][1], lines[2][1]); i++) {
                arr[i + 100] = true;
            }
        }
        if (lines[1][1] > lines[2][0]) {
            for (int i = lines[2][0]; i < Math.min(lines[1][1], lines[2][1]); i++) {
                arr[i + 100] = true;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) answer++;
        }
        
        return answer;
    }
}