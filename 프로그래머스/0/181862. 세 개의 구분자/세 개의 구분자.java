import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myStr.length(); i++) {
            char curC = myStr.charAt(i);
            if (curC == 'a' || curC == 'b' || curC == 'c') {
                if (sb.length() != 0) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(curC);
            }
        }
        
        if (sb.length() != 0) {
            list.add(sb.toString());
        }
        
        return (list.size() == 0) ? new String[]{"EMPTY"} : list.toArray(new String[list.size()]);
    }
}