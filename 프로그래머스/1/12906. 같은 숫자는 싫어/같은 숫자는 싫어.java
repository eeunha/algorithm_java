import java.util.*;

/*
I: int[] arr
O: int[] 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return
C: 배열 arr의 각 원소는 숫자 0부터 9까지
    단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지
E: arr.length == 1 -> return arr

배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거 -> 중복제거

ds:
algo:

pseudo:
arraylist 생성
맨 첫번째 값 arr[0] 을 arraylist에 넣기
현재 값(n) 변수 생성 후 arr[0]으로 초기화
1부터 끝까지 arr 순회 
    curArr이 n이랑 같으면 다음 수로 넘어감
    다르면 arraylist에 넣고 n=curArr
arraylist를 array로 변환 후 반환

time: O(N) N은 arr의 길이
space: O(N)
*/
public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int n = arr[0];
        
        for (int curArr : arr) {
            if (curArr == n) continue;
            list.add(curArr);
            n = curArr;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}