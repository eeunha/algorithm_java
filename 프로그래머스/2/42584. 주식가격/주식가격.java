class Solution {
    public int[] solution(int[] prices) {
        // edge cases
		if (prices.length == 1)
			return new int[] { 0 };

		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length - 1; i++) {

			int curPrice = prices[i];
			int time = 0;

			for (int j = i + 1; j < prices.length; j++) {
				
				time++;

				if (curPrice > prices[j])
					break;
			}

			answer[i] = time;
		}

		return answer;
    }
}