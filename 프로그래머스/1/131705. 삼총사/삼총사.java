class Solution {
    public int solution(int[] number) {
        // edge case
        if (number.length == 3) {
            return (number[0] == number[1] && number[1] == number[2]) ? 1 : 0;
        }

        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            int curNum = number[i];
            for (int j = i + 1; j < number.length - 1; j++) {
                curNum += number[j];
                for (int k = j + 1; k < number.length; k++) {
                    if (curNum + number[k] == 0) {
                        answer++;
                    }
                }
                curNum -= number[j];
            }
        }
        
        return answer;
    }
}