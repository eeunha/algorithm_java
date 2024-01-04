import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Set<String> set = new HashSet<>();
        int length = spell.length;
        int sameCount = 0;
        
        for (int i = 0; i < spell.length; i++) {
            set.add(spell[i]);
        }
        
        for (int i = 0; i < dic.length; i++) {
            String str = dic[i];
            if (str.length() != length) continue;
            
            set = new HashSet<>();
            for (int j = 0; j < spell.length; j++) {
                set.add(spell[j]);
            }
            
            sameCount = 0;
            
            for (int j = 0; j < str.length(); j++) {
                char curC = str.charAt(j);
                if (set.contains(String.valueOf(curC))) {
                    sameCount++; 
                    set.remove(String.valueOf(curC));
                } else {
                    break;
                }
            }
            
            if (sameCount == length) {
                return 1;
            }
        }
        
        return 2;
    }
}