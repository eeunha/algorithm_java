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
    
1. 학생 배열을 만들어서 체육복의 현재 상태 파악하기
    체육복이 없다 -> lost에 번호가 있다 -> 해당 번호에 -1
    체육복이 더 있다 -> reserve에 번호가 있다 -> 해당 번호에 +1
    본인 체육복만 있다 -> lost, reserve에 번호가 없다 -> 그대로 0
2. 학생 배열을 돌면서 대여를 한다.
    체육복이 없는 경우, continue
    체육복이 있는 경우, answer++
    체육복 여분이 있는 경우, 첫 번째 학생은 뒷번호만, 두 번째 학생은 앞 번호만.
    본인 앞 뒤 학생이 체육복이 없다면 빌려준다.
    본인 앞 학생을 빌려줄 떄 answer++
3. anwer 반환

 time: O(N)
 space: O(N)
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
