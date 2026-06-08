/*
26.06.08
I: int n
O: int[][]
C: 1 <= n <= 30

time: O(N^2)
space: O(N^2)
*/
class Solution {
    public int[][] solution(int n) {
        
        int[][] answer = new int[n][n];
        
        int x = 0;
        int y = 0;
        
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIdx = 0;
        
        for (int i = 1; i <= n * n; i++) {
            answer[x][y] = i;
            
            int newX = x + dir[dirIdx][0];
            int newY = y + dir[dirIdx][1];
            
            // 바꿀 좌표가 영역 밖이거나, 영역 안인데 방문함
            if ((newX >= n || newX < 0 || newY >= n || newY < 0) || answer[newX][newY] != 0) {
                // 방향 바꾸기
                dirIdx = (dirIdx + 1) % 4;
            }
            
            // 좌표 바꾸기
            x += dir[dirIdx][0];
            y += dir[dirIdx][1];
        }
        
        return answer;
    }
}