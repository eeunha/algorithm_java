/*
수포자 삼인방이 수학문제 전부 찍을것
1번 - 1 2 3 4 5 반복
2번 - 2 1 2 3 2 4 2 5 반복
3번 - 3 3 1 1 2 2 4 4 5 5 반복
가장 많은 문제를 맞힌 사람이 누구인지
번호를 배열에 담아 반환

I: int[] answers
O: int[]
C: answers.length <= 10000
    1 <= answers[i] <= 5
    가장 높은 점수 받은 사람이 여럿이면 오름차순 정렬
E: answers.length == 0 > return []

ds: array
algo: brute force

solution:
if (answers.length == 0) return new int[]{};

int[] pattern1 = {1, 2, 3, 4, 5};
int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
int pattern1Length = pattern1.length;
int pattern2Length = pattern2.length;
int pattern3Length = pattern3.length; // 굳이 변수로 안써도 성능 비슷 > 제거
int[] scores = new int[3];

for (int i = 0; i < answers.length; i++) {
    if (answers[i] == pattern1[i % pattern1Length]) {
        scores[0]++;
    }
    if (answers[i] == pattern2[i % pattern2Length]) {
        scores[1]++;
    }
    if (answers[i] == pattern3[i % pattern3Length]) {
        scores[2]++;
    }
}

int maxScore = 0;
for (int i = 0; i < scores.length; i++) {
    maxScore = Math.max(maxScore, scores[i]);
}

int idx = 0;
int maxCount = 0;
int[] curAnswer = new int[3];
for (int i = 0; i < scores.length; i++) {
    if (scores[i] == maxScore) {
        curAnswer[idx] = i + 1;
        maxCount++;
        idx++;
    }
}

int[] answer = new int[maxCount];
for (int i = 0; i < answer.length; i++) {
    answer[i] = curAnswer[i];
}

return answer;

time: O(N) N = answers.length
space: O(1)
*/
class Solution {
    public int[] solution(int[] answers) {
        // edge case
        if (answers.length == 0) return new int[]{};

        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                scores[0]++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                scores[1]++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                scores[2]++;
            }
        }

        // 최고점 찾기
        int maxScore = 0;
        for (int i = 0; i < scores.length; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }

        // 최고점 갖는 학생 번호 찾기
        int idx = 0;
        int maxCount = 0;
        int[] curAnswer = new int[3];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                curAnswer[idx] = i + 1;
                maxCount++;
                idx++;
            }
        }
    
        // 양식에 맞게 정리
        int[] answer = new int[maxCount];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = curAnswer[i];
        }

        return answer;
    }
}