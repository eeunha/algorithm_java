/*
I: int[] answer
O: int[]
C: 시험은 최대 10,000 문제
    문제의 정답은 1, 2, 3, 4, 5중 하나
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬
E:

[규칙]
1번: 1, 2, 3, 4, 5
2번: 2, 1, 2, 3, 2, 4, 2, 5
3번: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 

1,3,2,4,2

현재 수포자의 인덱스가 각 범위 내부에 있는지 확인하기
내부에 없다면 내부로 값 변경하기
내부에 있다면 정답과 비교하여 맞췄는지 확인하기
맞추면 각 score와 index를 증가시키기
반복

정답 개수 비교해서 가장 높은 점수가 2개 이상인지 확인하기
한명이면 바로 배열에 값 넣고 반환하기
두 명 이상이면 배열에 넣고 오름차순 정렬하여 반환하기

time:
space:
*/
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();

		// 수포자가 찍는 방식
		int[] pattern1 = { 1, 2, 3, 4, 5 };
		int[] pattern2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] pattern3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] scores = new int[4];

		for (int i = 0; i < answers.length; i++) {
			int curAnswer = answers[i];
			int idx1 = i % pattern1.length;
			int idx2 = i % pattern2.length;
			int idx3 = i % pattern3.length;

			// 정답과 비교하여 맞췄는지 확인하기
			// 맞추면 각 score를 증가시키기
			if (curAnswer == pattern1[idx1])
				scores[1]++;

			if (curAnswer == pattern2[idx2])
				scores[2]++;

			if (curAnswer == pattern3[idx3])
				scores[3]++;
		}

		// 가장 높은 값 찾기
		int max = Math.max(Math.max(scores[1], scores[2]), scores[3]);

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] == max) {
				list.add(i);
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
    }
}