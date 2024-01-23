/*
time: O(E * (V + E))
space: O(V^2 + V)
*/
class Solution {
    int[][] graph;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        visited = new boolean[n + 1];
        
        //인접행렬 만들기
        graph = new int[n + 1][n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            int towerA = wires[i][0];
            int towerB = wires[i][1];
            
            graph[towerA][towerB] = 1;
            graph[towerB][towerA] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int towerA = wires[i][0];
            int towerB = wires[i][1];
            
            graph[towerA][towerB] = 0;
            graph[towerB][towerA] = 0;
            
            int countA = dfs(towerA);
            int countB = dfs(towerB);
            
            answer = Math.min(answer, Math.abs(countA - countB));
            
            graph[towerA][towerB] = 1;
            graph[towerB][towerA] = 1;
        }
        
        return answer;
    }
    
    public int dfs(int tower) {
        // 현재 타워에서 갈 수 있는 타워 찾기
        // dfs 순회하기
        visited[tower] = true;
        int count = 1;
        
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i] && graph[tower][i] == 1) {
                count += dfs(i);
            }
        }
        visited[tower] = false;
        
        return count;
    }
}