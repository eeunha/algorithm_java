/*
I: int[][] maps
O: int 칸의 개수의 최솟값
C: 상대 팀 진영에 도착할 수 없을 때는 -1을 return
    maps는 n x m
    n과 m은 각각 1 이상 100 이하의 자연수
    n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
    maps는 0과 1로만, 0은 벽이 있는 자리, 1은 벽이 없는 자리
    처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
E: maps[0][0] == 0 -> return -1

1,1에서 n,m까지 가는 최단 거리 구하기

ds: array
algo: bfs -> 최단거리

time: O(NM)
space: O(NM)
*/
import java.util.*;

class Solution {
    private int[] xArr = {-1, 0, 1, 0};
    private int[] yArr = {0, 1, 0, -1};
    private boolean[][] visited;
    
    public int solution(int[][] maps) {
        //edge cases
        if (maps[0][0] == 0) return -1;
        
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<List<Integer>> queue = new LinkedList<>();
        visited = new boolean[n][m];
        
        queue.offer(new ArrayList<>(List.of(0, 0, 1)));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            List<Integer> curList = queue.poll();
            int x = curList.get(0);
            int y = curList.get(1);
            int count = curList.get(2);
            
            if (x == n - 1 && y == m - 1) {
                return count;
            }
            
            if (maps[x][y] == 1) {
                // 사방으로 갈 수 있는지 확인하기. 갈 수 있는 것만 큐에 넣기.
                for (int i = 0; i < 4; i++) {
                    int newX = x + xArr[i];
                    int newY = y + yArr[i];
                    
                    if (newX >= 0 && newX < maps.length && newY >= 0 && newY < maps[0].length && maps[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.offer(new ArrayList<>(List.of(newX, newY, count + 1)));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return -1;
    }
}