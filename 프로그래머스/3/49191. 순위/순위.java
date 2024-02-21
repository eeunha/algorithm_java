/*
1번 - 승: 2, 패: x
2번 - 승: 5, 패: 4, 3, 1
3번 - 승: 2, 패: 4
4번 - 승: 3, 2, 패: X
5번 - 승: X, 패: 2
*/
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
		for (int[] edge : results) {
			graph[edge[0]][edge[1]] = 1;
			graph[edge[1]][edge[0]] = - 1;
		}

		//출발
		for (int i = 1; i <= n; i++) {
			//도착
			for (int j = 1; j <= n; j++) {
				//거쳐감
				for (int k = 1; k <= n; k++) {
					if(graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
						graph[j][i] = -1;
					}
					
					if(graph[i][k] == -1 && graph[k][j] == -1) {
						graph[i][j] = -1;
						graph[j][i] = 1;
					}
				}
			}
		}
		
		int answer = 0;
		
		for(int i = 0 ; i <=n; i++) {
			int count = 0;
			for (int j = 0; j <= n; j++) {
				if(graph[i][j] != 0) count++;
			}
			if(count == n-1) answer++;
		}
        return answer;
    }
}