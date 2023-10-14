package programmers;

import java.util.HashMap;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/*
	    I: int[] 2개
	    O: String
	    C: 참여한 선수의 수는 1명 이상 100,000명 이하
	        completion의 길이는 participant의 길이보다 1 작습니다.
	        참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자
	        참가자 중에는 동명이인이 있을 수 있습니다.
	    E: participant.length == 1 -> return participant[0];
	
	    map에 completion에 있는 이름과 이름이 나온 횟수를 넣는다.
	    맵이 다 만들어지면 참가자 이름을 하나씩 맵에 들어있나 확인한다.
	    존재하면 횟수를 1 줄인다.
	    만약 횟수가 0이 되면 아예 이름을 지운다.
	    마지막 남은 하나의 이름을 반환한다.
	
	    time: O(N)
	    space: O(N)
	 */
	public String solution(String[] participant, String[] completion) {
		//edge case
        if (participant.length == 1) return participant[0];
        
		String answer = "";

		HashMap<String, Integer> map = new HashMap<>();
		for (String name : completion) {
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		for (String name : participant) {
			if (map.containsKey(name)) {
				int val = map.get(name);
				if (val == 1) {
					map.remove(name);
				} else {
					map.replace(name, val - 1);
				}
			} else {
				answer = name;
				break;
			}
		}

		return answer;
	}

}
