package programmers;

import java.util.HashMap;

// 23.10.15
public class PhoneBookList_map {
	public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String s : phone_book){
            map.put(s, 0);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            
            for (int j = 0; j < s.length(); j++)  {
                String substr = s.substring(0, j);
                if (map.containsKey(substr)) return false;
            }
        }

        return true;
    }
}

