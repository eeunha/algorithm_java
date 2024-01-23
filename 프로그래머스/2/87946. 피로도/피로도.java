/*

*/
import java.util.*;
class Solution {
    boolean[] visited;
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        for (int i = 0; i < dungeons.length; i++) {
            Arrays.fill(visited, false);
            dfs(i, dungeons, k, 0);    
        }
        
        return answer;
    }
    
    public void dfs(int idx, int[][] dungeons, int k, int count) {
        //현재 인덱스를 방문할 수 있는가?
        if (!visited[idx] && dungeons[idx][0] <= k) {
            visited[idx] = true;
            
            for (int i = 0; i < dungeons.length; i++) {
                dfs(i, dungeons, k - dungeons[idx][1], count + 1);
            }
            
            visited[idx] = false;
        }
        //있다면
        //visited = true
        //for문으로 dungeons 1번부터 length까지 모두 방문하면서 dfs 돌기
        //visited = false
        
        else {
            answer = Math.max(answer, count);
        }
        //없다면
        //answer에 answer과 count중 큰 값 넣기
    }
}