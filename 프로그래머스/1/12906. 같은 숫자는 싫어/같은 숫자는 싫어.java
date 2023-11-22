import java.util.*;

/*
 I: int[] arr  0~9로 이루어짐
 O: int[]
 C: 배열 arr의 크기 : 1,000,000 이하의 자연수
 	배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 E: arr.length == 1 -> return arr;
 
 연속되는 숫자를 하나만 남기고 제거하기
 원소 순서는 유지
 
 모든 원소가 유일 -> result가 arr과 같음
 ~
 모든 원소가 동일 -> result 원소가 arr[0]로 하나만 존재
 
 result 배열의 길이를 모르니, 먼저 ArrayList로 생성 후 이를 int[]로 변환하는 작업 필요
 
 algo: 순회, 비교
 ds: 스택. 진짜 스택은 아니고 left와 right로 비교하기
 
 [1,1,3,3,0,1,1]
            l
                 r
 l = 0, r = 0
 -> list.add(arr[l]);
 -> r++;
 		
 l = 0, r = 1
 l == r -> r++;
 
 l = 0, r = 2
 l != r -> list.add(arr[r]);
 		-> l = r;
 		-> r++;
 
 l = 2, r = 3
 l == r -> r++;
 
 l = 2, r = 4
 l != r -> list.add(arr[r]);
 		-> l = r;
 		-> r++;
 
 l = 4, r = 5
 l != r -> list.add(arr[r]);
 		-> l = r;
 		-> r++;
 		
 l = 5, r = 6
 l == r -> r++;
 
 r > arr.length
 => 종료
 		
 list [1,3,0,1]
 -> arr로 변경하기
 
 time: O(n), n = arr.length
 space: O(n), n = arr.length
*/
public class Solution {
    public int[] solution(int []arr) {
        // edge case
		if (arr.length == 1)
			return arr;

		ArrayList<Integer> list = new ArrayList<>();
		int[] result;

		int l = 0;
		int r = 0;

		list.add(arr[0]);

		while (r < arr.length) {
			if (arr[l] != arr[r]) {
				list.add(arr[r]);
				l = r;
			}
			r++;
		}

		result = list.stream().mapToInt(i -> i).toArray();

		return result;
    }
}