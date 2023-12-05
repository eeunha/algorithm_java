import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        if (my_string.length() == 1) return new String[]{my_string};
        
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            list.add(my_string.substring(i));
        }
        
        list.sort(Comparator.naturalOrder());
        
        return list.toArray(new String[list.size()]);
    }
}