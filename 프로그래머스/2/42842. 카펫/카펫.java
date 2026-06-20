/*
중앙은 노란색, 테두리 1줄은 갈색
노란색과 갈색의 격자 개수는 알지만 전체 카펫 크기는 모름

I: int brown, int yellow
O: int[] 
C: 8 <= brown <= 5000
    1 <= yellow <= 2,000,000
    가로 길이 >= 세로 길이
E:

b = 10, y = 2 
b b b b > 4 * 3 > [4, 3]
b y y b
b b b b
brown = 가로길이 * 2 + (세로길이 - 2) * 2
    = 4 * 2 + 1 * 2 = 10
>> y의 모양에 따라 b가 달라짐
> y 배치가 관건.

brown 으로 가로 세로 길이를 세워보기
세운 가로세로를 곱해서 너비를 구하기
그 너비와 b + y 가 같은지 확인
같다면 가로 세로가 맞은 경우 > return [가로, 세로]
아니라면 이어나가기

b = 가 * 2 + (세 - 2) * 2
b + y = 가 * 세

1. 
3 <= 한 변의 길이 <= b/2 - 1
b, y, 가로(혹은 한 변) 안다고 하면
세로 = b / 2 - 가로 + 2
> 가로 세로 구하기

2. 
가로 * 세로 = b + y 인가

둘 다 맞다면 긴 변이 가로.

ds:
algo: brute force

time: O(N) N = brown
space: O(1)
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // i는 한 변의 길이일 때
        for (int i = 3; i < brown / 2; i++) {
            // 1. 다른 한 변의 길이 구하기
            int height = brown / 2 - i + 2;
            
            // 2. 구한 가로세로가 맞는지
            if (i * height == brown + yellow) {
                // 3. 긴 변이 가로
                if (i > height) {
                    answer[0] = i;
                    answer[1] = height;
                } else {
                    answer[0] = height;
                    answer[1] = i;
                }
                break;
            }
        }
        return answer;
    }
}