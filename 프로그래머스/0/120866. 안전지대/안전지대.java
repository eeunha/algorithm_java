/*
I: int[][] board
O: int
C: board는 n * n 배열
   1 ≤ n ≤ 100
   지뢰는 1
   board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재
E: board.length == 1  -> board[0][0] == 1 => return 1;
                                     == 0 => return 0;

time:
space:
*/
class Solution {
    public int solution(int[][] board) {
        //edge cases
        if (board.length == 1) {
            return (board[0][0] == 1) ? 0 : 1;
        }
        
        int answer = 0;
        int[] iArr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] jArr = {-1, 0, 1, 1, 1, 0, -1, -1};
        boolean boom;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if  (board[i][j] == 1) continue;
                
                boom = false;
                
                for (int k = 0; k < iArr.length; k++) {
                    int newI = i + iArr[k];
                    int newJ = j + jArr[k];
                    
                    if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board.length && board[newI][newJ] == 1) {
                        boom = true;
                        break;
                    }
                }
                if (!boom) {
                    answer++;
                }
            }
        }
        return answer;
    }
}