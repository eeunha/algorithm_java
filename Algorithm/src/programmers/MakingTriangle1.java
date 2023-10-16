package programmers;

public class MakingTriangle1 {
	public int solution(int[] sides) {
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;

		// 가장 긴 변의 인덱스 찾기
		for (int i = 0; i < sides.length; i++) {
			if (sides[i] > max) {
				max = sides[i];
				maxIdx = i;
			}
		}

		if (maxIdx == 0) {
			if (sides[0] < sides[1] + sides[2])
				return 1;
			else
				return 2;
		} else if (maxIdx == 1) {
			if (sides[1] < sides[0] + sides[2])
				return 1;
			else
				return 2;
		} else {
			if (sides[2] < sides[1] + sides[0])
				return 1;
			else
				return 2;
		}
	}

	public int solution2(int[] sides) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        // 가장 긴 변 찾기
        for (int i = 0; i < sides.length; i++) {
            sum += sides[i];
            if (sides[i] > max) max = sides[i];
        }
        
        return (sum - max > max) ? 1 : 2;
    }
}
