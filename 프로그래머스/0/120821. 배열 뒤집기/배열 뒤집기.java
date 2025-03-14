/*
num_list의 원소의 순서를 거꾸로 뒤집은 배열 반환

I: int[] num_list
O: int[]
C: 1 ≤ num_list의 길이 ≤ 1,000
    0 ≤ num_list의 원소 ≤ 1,000
E: num_list.length == 1 > return num_list

pseudo:
길이가 같은 새 배열 하나 생성
num_list의 맨 뒤부터 앞까지 값 하나씩 읽기
해당 값을 0부터 끝까지 새 배열에 하나씩 넣기
새 배열 반환하기

time: O(N)
space: O(N)

solution:

*/
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int length = num_list.length;
        
        for (int i = 0; i < length; i++) {
            answer[i] = num_list[length - 1 - i];
        }
        
        return answer;
    }
}