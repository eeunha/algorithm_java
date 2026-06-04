/*
    * 26.06.04
    * 삼총사
    *
    * 학생들이 각자 정수 번호 가짐.
    * 세명의 정수 번호를 더했을 때 0이 되면 셋은 삼총사다.
    *
    * I: int[] number
    * O: int 삼총사를 만들 수 있는 방법의 수
    * C: 3 <= number.length <= 13
    *    -1000 <= number의 각 원소 <= 1000
    *    번호 중복 있음
    * E: number.length == 3 >> 세 번호 더해서 0이면 return 1, 아니면 return 0
    *
    * 1. 완전 탐색
    * 이걸 만약 세번 순회하면 O(N^3)이다. 하지만 최대 학생수가 13이라 적어서 가능할지도?
    * >> 가능. N의 범위가 커진다면 투 포인터나 정렬 고려 필요.
    *
    * 2. 투 포인터 (O(N^2) / O(1))
    * number 정렬
    * 한명 멤버 고정 후 두 멤버 찾기
    * 양 끝에서 범위 좁혀가기 - 같은 숫자라면 넘어가기
    * - leetcode의 3Sum 문제와 비슷하나, 중복값이 있어도 인덱스가 다르면 카운트해야함 
    *   >> 3중 반복문이 직관적이고 효율적.
    * 
    * ds: array
    * algo: brute force
    *
    * time: O(N^3)
    * space: O(1)
    * */
class Solution {
    public int solution(int[] number) {
        // edge case
        if (number.length == 3) {
            return (number[0] + number[1] + number[2] == 0) ? 1 : 0;
        }

        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            int curNum = number[i];
            for (int j = i + 1; j < number.length - 1; j++) {
                curNum += number[j];
                for (int k = j + 1; k < number.length; k++) {
                    if (curNum + number[k] == 0) {
                        answer++;
                    }
                }
                curNum -= number[j];
            }
        }
        
        return answer;
    }
}