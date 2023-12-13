import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        String[] arr = my_string.split("");
        
        for (int idx : indices) {
            arr[idx] = "";
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}