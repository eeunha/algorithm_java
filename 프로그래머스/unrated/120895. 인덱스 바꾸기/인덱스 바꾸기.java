class Solution {
    public String solution(String my_string, int num1, int num2) {
        String subStr1 = my_string.substring(num1, num1 + 1);
        String subStr2 = my_string.substring(num2, num2 + 1);
        return my_string.substring(0, num1) + subStr2 + my_string.substring(num1 + 1, num2) + subStr1 + my_string.substring(num2 + 1);
    }
}