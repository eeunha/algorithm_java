import java.util.*;
class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                //모드 변경
                mode = (mode == 0) ? 1 : 0;
            } else if (i % 2 == mode) {
                //문자
                sb.append(code.charAt(i));
            } 
        }
        
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}