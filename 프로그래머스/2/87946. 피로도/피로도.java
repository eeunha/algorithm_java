/*
time: O(N^N)
space: O(N)
*/
import java.util.*;
class Solution {
    boolean[] visited;
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, k, 0);    
        
        return answer;
    }
    
    public void dfs(int[][] dungeons, int k, int count) {
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(dungeons, k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, count);
    }
}