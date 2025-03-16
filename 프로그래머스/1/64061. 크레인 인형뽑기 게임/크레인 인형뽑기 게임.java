import java.util.*;

/*
I: int[][] board, int[] moves
O: int
C: board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하
    board의 각 칸에는 0 이상 100 이하인 정수
       0은 빈 칸 
       1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형
    moves 배열의 크기는 1 이상 1,000 이하
    moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수
E:

nxn 정사각 격자, 오른쪽에는 바구니
인형이 없는 칸은 빈칸
모든 인형은 1x1 한칸 차지
격자의 가장 아래 칸부터 차곡차곡 쌓여 있음 -> stack
크레인으로 가장 위의 인형 집음 -> 바구니에 인형 쌓임(아래부터 쌓임 -> stack)
같은 모양 2개 연속 -> 2개 사라짐
인형 있을 때 안잡는 경우 없다
인형 없을 때 아무일 없음
바구니 크기 제약 없음

[0,0,0,0,0]
[0,0,1,0,3]
[0,2,5,0,1]
[4,2,4,4,2]

moves 값은 -1 해야 board의 인덱스와 맞음
인형을 꺼낼 때 board에 값이 있는지 확인해야 함
인형을 꺼낼 때마다 스택에 현재 값과 이전 값을 비교해 같은지 확인. 같다면 answer에 +2
다르다면 스택에 그냥 넣기

ds: stack
algo:

pseudo:
결과물 저장할 answer 변수 생성
바구니인 stack 생성
moves 값 하나씩 읽기
    board[i][j(읽은 값-1)] -> i를 0부터 n-1까지 순회하며 해당 칸에 값이 있는지 확인
        값이 없다면 다음 i로 넘김
        값이 있다면 board[i][j] 를 바구니에 넣으려 함.
            바구니가 비어있거나, 비지 않았는데 맨 위의 값과 다르다면 push
            바구니가 채워져있고 맨 위의 값과 다르다면 pop 후 answer += 2
answer 반환

time: O(MN)
space: O(M)

solution:
*/
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            int j = move - 1;
            
            for (int i = 0; i < board.length; i++) {
                int curVal = board[i][j];
                
                if (curVal == 0) continue;
                
                board[i][j] = 0;
                
                if (!stack.isEmpty() && stack.peek() == curVal) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(curVal);
                }
                
                break;
            }
        }
        
        return answer;
    }
}