package programmers;

import java.util.HashSet;

/*
	I: int[]
	O: int = 폰켓몬 종류 번호의 개수
	C:  nums는 폰켓몬의 종류 번호가 담긴 1차원 배열
	    nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수
	    폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수
	    가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return
	E: nums.length == 2 -> return 1;
	
	DS: hash map 
	
	같은 종류의 폰켓몬 = 같은 번호
	다양한 종류의 폰켓몬 가질래
	n/2마리 고르기
	해당 폰켓몬 종류 번호의 개수 반환
	
	1번 예제
	nums.length == 4 -> 2개 고르기
	종류 개수
	1 - 1
	2 - 1
	3 - 2
	
	1,2 | 2,3 | 1,3 | 3,3 -> 4가지
	최대한 다양 -> 1,2 | 2,3 | 1,3 -> 각 1개씩 2종류
	return 2;
	
	2번 예제
	nums.length == 6 -> 3개 고르기
	종류 개수
	2 - 2
	3 - 3
	4 - 1
	순서쌍: 2,3,4 | 2,2,3 | 2,2,4 | 2,3,3 | 3,3,3 | 3,3,4 | 3,3,3
	
	일단 해시맵에 다 넣기
	if (해시맵 크기 >= nums.length/2) -> 각 1개씩 3 종류가 가능하다는 이야기 => return 3;
	else 중복된 폰켓몬이 있다. ->  
	
	예시
	nums.length = 10 -> 5개 고르기
	if map.size >= 5 -> return 5;
	if map.size = 4 -> return 4; 
	if map.size = 3 -> return 3; 
	if map.size = 2 -> return 2; 
	if map.size = 1 -> return 1;
	=> map.size 출력
	
	pseudo code:
	map에 nums 넣기
	map의 크기 구하기
	if(map.size() >= nums.length/2) return nums.length/2;
	else return map.size()
	
	solution:
	
	time: O(N)
	space: O(N)
  
 */
public class Ponketmon {
	public int solution(int[] nums) {
		// edge cases
		if (nums.length == 2)
			return 1;

		// map에 넣기
		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		// map 크기 확인하기
		if (set.size() >= nums.length / 2) {
			return nums.length / 2;
		}

		return set.size();
	}
}
