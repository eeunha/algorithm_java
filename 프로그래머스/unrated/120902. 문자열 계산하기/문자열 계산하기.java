class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split(" ");
        answer = Integer.parseInt(arr[0]);
        String operator = "";
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("+") || arr[i].equals("-")) {
                operator = arr[i];
            } else {
                answer = (operator.equals("+")) ? answer + Integer.parseInt(arr[i]) : answer - Integer.parseInt(arr[i]);
            }
        }
        return answer;
    }
}