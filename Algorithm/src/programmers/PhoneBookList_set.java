package programmers;

import java.util.HashSet;

// 23.10.15
public class PhoneBookList_set {
	public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for (String s : phone_book){
            set.add(s);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            String s = phone_book[i];
            
            for (int j = 0; j < s.length(); j++)  {
                String substr = s.substring(0, j);
                if (set.contains(substr)) return false;
            }
        }

        return true;
    }

}
