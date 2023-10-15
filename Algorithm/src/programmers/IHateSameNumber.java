package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	I: int[] arr
	O: int[]
	C: 배열 arr의 크기 : 1,000,000 이하의 자연수
	    배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
	E: if (arr.length == 1) return arr;
	
	DS: stack
	Algo:
	
	stack을 하나 생성한다.
	배열을 순회하면서 스택에 값을 하나씩 넣는다.
	스택의 맨 위의 값과 현재 넣을 값을 비교한다.
	    값이 같은 경우, 다음 수로 넘어간다.
	    값이 다른 경우, 스택에 현재 수를 넣고 다음 수로 넘어간다.
	순회가 다 끝나면 스택을 배열로 바꾸고 해당 배열을 반환한다.
	
	stack을 arraylist로 구현하여 사용한다.
	
	time: O(N)
	space: O(N)
*/
public class IHateSameNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		// edge cases
		if (arr.length == 1)
			return arr;

		List<Integer> list = new ArrayList<>();
		
		int top = -1;
		
		for (int n : arr) {
			if (top == -1 || list.get(top) != n) {
				list.add(n);
				top++;
			} else {
				continue;
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

}
