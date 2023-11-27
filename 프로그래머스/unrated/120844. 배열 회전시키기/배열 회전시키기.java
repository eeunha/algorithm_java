class Solution {
    public int[] solution(int[] numbers, String direction) {
        //edge cases
        if (numbers.length == 1) return numbers;
        
        int[] answer = new int[numbers.length];
        
        if (direction.equals("right")) {
            answer[0] = numbers[numbers.length - 1];
            for (int i = 0; i < numbers.length - 1; i++) {
                answer[i + 1] = numbers[i];
            }
        } else {
            answer[answer.length - 1] = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                answer[i - 1] = numbers[i];
            }
        }
        
        return answer;
    }

    public int[] solution2(int[] numbers, String direction) {
        //edge cases
        if (numbers.length == 1) return numbers;
        
        int[] answer = new int[numbers.length];
        
        int start = 0;
        int end = numbers.length - 2;
        int dir = 1;
        answer[0] = numbers[numbers.length - 1];

        if (direction.equals("left")) {
            start++;
            end++;
            answer[answer.length - 1] = numbers[0];
            dir = -1;
        }
        
        for (int i = start; i <= end; i++) {
            answer[i + dir] = numbers[i];
        }
        
        return answer;
    }
}
