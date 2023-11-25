import java.util.*;

/*
time: O(n)
space: O(1)
*/
class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String num = age + "";
        
        for (int i = 0; i < num.length(); i++) {
            char c = (char) ((int) num.charAt(i) + 49);
            sb.append(c);
        }
        
        return sb.toString();
    }
}