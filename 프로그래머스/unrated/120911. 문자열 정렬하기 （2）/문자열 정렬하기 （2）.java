import java.util.*;
class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        my_string = my_string.toLowerCase();
        
        String[] arr = my_string.split("");
        
        Arrays.sort(arr);
        
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}