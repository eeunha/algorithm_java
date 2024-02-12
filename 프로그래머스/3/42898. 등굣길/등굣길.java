/*
I: int m 가로, n 세로, int[][] puddles
O: int
C: 오른쪽과 아래로만 움직일 수 있다.
    격자의 크기 m, n은 1 이상 100 이하인 자연수
    m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
    물에 잠긴 지역은 0개 이상 10개 이하
    집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
E:

집의 오른쪽과 아래에 물이 있는 경우 또는 학교의 왼쪽과 위에 물이 있는 경우는 경로가 없다.

1. 도착지까지 최단 거리를 구한다.
2. 최단 거리를 가지는 경로의 개수를 구한다.
-> 이걸 한번에 할 수 있을까?

ds: array
algo: dp

time: O(N * M)
space: O(N * M)
*/

import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1] [m + 1];
        int mod = 1000000007;
        
        for (int[] temp : puddles) {
            dp[temp[1]][temp[0]] = -1;
        }
        
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) continue;
                
                if (dp[i - 1][j] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                }
                
                if (dp[i][j - 1] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
                }
            }
        }
        return dp[n][m];
    }
}