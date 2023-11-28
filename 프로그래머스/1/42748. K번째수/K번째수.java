import java.util.*;
/*
I: int[] array, int[][] commands
O: int[] answer
C: array의 길이는 1 이상 100 이하
    array의 각 원소는 1 이상 100 이하
    commands의 길이는 1 이상 50 이하
    commands의 각 원소는 길이가 3 (1부터 시작)
E: 

commands[][0] = i = 자르기 시작한 인덱스
commands[][1] = j = 자르는 마지막 인덱스
commands[][2] = k = k번째 있는 수

ds: 정렬
algo:

- i = j -> array[i] 를 배열에 넣기

- i != j -> 잘라서 배열로 만들기
i~j까지 자르기
정렬하기
k번째 수 찾아서 결과 배열에 넣기

int[] answer = new int[commands.length];
배열을 잘라서 배열로 만들기

time: O(m*nlogn), n = commands.length, m = temp.length
space: O(n), n = commands.length
*/
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
		int index = 0;

		for (int i = 0; i < commands.length; i++) {
			int startIdx = commands[i][0] - 1; //자르기 시작할 인덱스
			int endIdx = commands[i][1];    //마지막으로 잘리는 인덱스 + 1
			int findIdx = commands[i][2] - 1; //찾아야 할 인덱스

			if (startIdx == endIdx) { //하나의 숫자만 자를 경우
				answer[index] = array[startIdx]; //결과를 반환할 배열에 저장
			} else { //여러 개의 숫자를 자를 경우
				int[] temp = Arrays.copyOfRange(array, startIdx, endIdx);
				Arrays.sort(temp);
				answer[index] = temp[findIdx]; //결과를 반환할 배열에 저장
			}
            index++; //반환할 배열의 인덱스 증가
		}

		return answer;
    }
}