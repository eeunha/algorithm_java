import java.util.*;

class Solution {
    public String solution(String s) {
        
        //edge case
        if (s.length() == 1) return s;
        
        StringBuilder sb = new StringBuilder();
        
        int[] countArr = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char curC = s.charAt(i);
            
            countArr[curC - 'a']++;
        }
        
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 1) {
                sb.append((char)(i + 97));
            }
        }
        
        return sb.toString();
    }
}