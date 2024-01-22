/*
I: int n, int[][] wires - 인접행렬
O: int
C: n은 2 이상 100 이하인 자연수
    wires는 길이가 n-1인 정수형 2차원 배열
    wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며, 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
    1 ≤ v1 < v2 ≤ n 
    전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
E:

ds:
algo:

time:
space:
*/
import java.util.*;
class Solution {
    
    int[][] graph;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        //edge cases
        if (n == 2) return 0;
        
        int answer = Integer.MAX_VALUE;
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        //인접 행렬 생성
        for (int i = 0; i < wires.length; i++) {
            int tower1 = wires[i][0];
            int tower2 = wires[i][1];
            
            graph[tower1][tower2] = 1;
            graph[tower2][tower1] = 1;
        }
        
        for (int i = 0; i < wires.length; i++) {
            //경로 하나씩 제거하기
            int tower1 = wires[i][0];
            int tower2 = wires[i][1];
            
            graph[tower1][tower2] = 0;
            graph[tower2][tower1] = 0;
            
            Arrays.fill(visited, false);
            int nodes1 = dfs(tower1);
            
            Arrays.fill(visited, false);
            int nodes2 = dfs(tower2);
            
            answer = Math.min(answer, Math.abs(nodes1 - nodes2));
            
            graph[tower1][tower2] = 1;
            graph[tower2][tower1] = 1;
        }
        
        return answer;
    }
    
    public int dfs(int startTower) {
            
        visited[startTower] = true;
        int curTowers = 1;
        
        for (int i = 1; i < graph.length; i++) {
            if (graph[startTower][i] == 1 && !visited[i]) {
                curTowers += dfs(i);
            }
        }
        visited[startTower] = false;
        
        return curTowers;
    }
}