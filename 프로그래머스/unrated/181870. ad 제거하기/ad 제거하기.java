import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < strArr.length; i++) {
            String curS = strArr[i];
            if (!curS.contains("ad"))
                list.add(curS);
        }
        
        return list.toArray(new String[list.size()]);
    }
}