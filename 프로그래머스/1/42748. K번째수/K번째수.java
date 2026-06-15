/*
I: int[] array, int[][] commands
O: int[]
C: 1 <= array.length <= 100
    1 <= array 원소 <= 100
    1 <= commands.length <= 50
    commands 원소.length = 3
E:

배열의 i번째 숫자부터 j번째 숫자까지 자르기
자른 배열 정렬하기
정렬된 배열의 k번째 있는 수 찾기

ds: array
algo: sort

solution:
int[] answer = new int[commands.length];
배열을 i-1부터 j-1 인덱스까지 잘라서 다른 배열로 만들기
자른 배열을 정렬하기
k-1 인덱스에 있는 숫자를 찾아서 결과 배열에 넣기
결과 배열 반환

time: O(NlogN) 정렬, N = array.length
space: O(N)
*/
import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] curCommand = commands[i];
            int[] newArr = Arrays.copyOfRange(array, curCommand[0] - 1, curCommand[1]);
            
            Arrays.sort(newArr);
            
            int k = curCommand[2] - 1;
            
            answer[i] = newArr[k];
        }
        
        return answer;
    }
}