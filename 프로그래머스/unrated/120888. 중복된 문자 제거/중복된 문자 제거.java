import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            char curC = my_string.charAt(i);
            if (!set.contains(curC)){
                sb.append(curC);
                set.add(curC);
            }
        }
        
        return sb.toString();
    }
}