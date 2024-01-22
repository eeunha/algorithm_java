/*
I: int k, int[][] dungeons
O: int
C: k는 1 이상 5,000 이하인 자연수
    dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하
    dungeons의 가로(열) 길이는 2
    dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"]
    "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
    "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수
    서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.
E:

ds: array
algo: dfs

time:
space:
*/
class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            dfs(i, k, dungeons, new boolean[dungeons.length], 0);  
        }
        
        return answer;
    }
    
    public void dfs(int startIdx, int k, int[][] dungeons, boolean[] visited, int curVisitedDungeons) {
        
        //현재 노드를 방문할 수 있는가?
        if (!visited[startIdx] && k >= dungeons[startIdx][0]) {
            //있다면
            k -= dungeons[startIdx][1];
            visited[startIdx] = true;
            curVisitedDungeons++;
            
        } else {
            //없다면
            answer = Math.max(answer, curVisitedDungeons);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            dfs(i, k, dungeons, visited, curVisitedDungeons);
        }
        
        visited[startIdx] = false;
        k += dungeons[startIdx][1];
    }
}