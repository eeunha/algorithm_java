import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(intArr);
        return intArr[0] + " " + intArr[intArr.length - 1];
    }
}