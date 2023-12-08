/*
 I: int n - 전체 학생 수, int[] lost - 도난당한 학생 번호, int[] reserve - 여분 있는 학생 번호
 O: int 체육복 입는 최대 학생 수
 C: 전체 학생의 수는 2명 이상 30명 이하
    체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없다
    여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없다
    여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있다
    여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없다.
 E:
 
 전체 학생 수: n명
 -> 학생 번호는 1 ~ n
 
 1. 체육복이 없는 학생
    -> 앞 뒤 학생에게 빌리기
 2. 체육복이 본인만 있는 학생
    -> lost와 reverse에 번호가 없는 학생
 3. 체육복 여분이 있는 학생
    3.1. 체육복 여분이 있어 빌려줄 수 있는 학생
    3.2. 체육복 여분이 있지만 잃어버린 학생 -> 2. 와 동일
    
1. 본인 체육복이 있는 학생 수 세기
set에 lost와 reserve를 돌면서 값을 넣는다. 
set의 크기가 체육복이 없거나 여분이 있는 학생이다 -> n-size 찾기

2. 

 time:
 space:
*/
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

		int[] student = new int[n + 1];

		for (int i = 0; i < lost.length; i++) { // 잃어버린 학생
			student[lost[i]] = -1;
		}

		for (int i = 0; i < reserve.length; i++) { // 여분이 있는 학생
			student[reserve[i]] += 1;
		}

		for (int i = 1; i < student.length; i++) {
			if (student[i] == -1) {
				continue;
			}

			answer++;

			if (student[i] == 1) {

				// 이전 번호 학생이 체육복이 없는 경우
				if (i != 1 && student[i - 1] == -1) {
					answer++; // 이전 학생 수 추가
					student[i - 1] += 1;
					student[i] -= 1;
				} else if (i != n && student[i + 1] == -1) { // 다음 번호 학생이 체육복이 없는 경우
					student[i + 1] += 1;
					student[i] -= 1;
				}

			}
		}

		return answer;
    }
}