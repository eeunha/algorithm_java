import java.util.*;

/*
I: int[] progresses, int[] speeds
O: int[]
C: 작업의 개수(progresses, speeds배열의 길이)는 100개 이하
    작업 진도는 100 미만의 자연수
    작업 속도는 100 이하의 자연수
    배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
    예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
E: progresses.length == 1 > return [1]

[93, 30, 55]
94 60 60
95 90 65
96 120 70
97 150 75 > 여기서 이미 이전값이 100 넘었기 때문에 안더하고 120 그대로 있어도 될듯
98 180 80
99 210 85
100 240 90 > 맨 앞이 100 도달 > 배포(poll) 시작
    여기서 변수 하나 생성(배포할 프로그램 개수) 후 1로 초기화
    > 100 미만 수 나올 때까지 변수에 값 증가
    > 100 미만 수 나오면 결과 배열에 현재 변수(프로그램 개수) 넣기 + 남은 프로그램 개수에서 현재 프로그램 개수 빼기


ds: queue > 근데 배열 그대로 사용
algo:

pseudo:
남은 작업의 개수를 담을 변수 생성 후 progresses 길이로 초기화
남은 작업이 0개가 될 때까지 반복 (일자)
    progresses 에 speeds 각각 더하기
    만약 progresses 맨 앞의 값이 100 이상일 경우 > 배포
    progresses 배열 순회하면서 100 미만 숫자 나올 때까지 배포 개수 세기
    100미만 숫자 나오면 결과 배열에 배포 개수 넣고 남은 작업에서 배포 수 빼기
결과 배열 반환

time: O(N^2) N은 progresses 길이
space: O(N)
*/
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //edge case
        if (progresses.length == 1)
            return new int[]{1};
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int length =  progresses.length;
        int front = 0;
        
        while (front < length) {
            if (front == length - 1) {
                result.add(1);
                break;
            }
            
            int days = (100 - progresses[front]) / speeds[front];
            days += ((100 - progresses[front]) % speeds[front] != 0) ? 1: 0;
            
            for (int i = front; i < length; i++) {
                progresses[i] += days * speeds[i];
            }
            
            int finished = 0;
            
            for (int i = front; i < length; i++) {
                if (progresses[i] >= 100) {
                    finished++;
                } else {
                    front = i;
                    result.add(finished);
                    finished = 0;
                    break;
                }
            }
            
            if (finished != 0) {
                result.add(finished); 
                front = length;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}