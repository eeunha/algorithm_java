import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/*
I: int[] arr, int divisor
O: int[]
C: arr은 자연수를 담은 배열
    divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환
    정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j]
    divisor는 자연수
    array는 길이 1 이상인 배열
E:

pseudo:
arraylist 생성
arr 순회
각 값이 divisor로 나누어지는지 확인
    나누어진다면 arraylist에 넣기
arraylist 길이 확인
    0 > -1 넣기
    0이상 > arraylist 오름차순 정렬
arraylist를 배열로 변경
배열 반환

time: O(N)
space: O(N)

solution:
*/
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : arr) {
            if (n % divisor == 0) {
                list.add(n);
            }
        }
        
        if (list.size() > 0) {
            Collections.sort(list);
        } else {
            list.add(-1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}