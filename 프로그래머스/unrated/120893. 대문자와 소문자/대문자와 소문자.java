class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            String s = c + "";
            
            if (c >= 'a' && c <= 'z') {
                sb.append(s.toUpperCase());
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(s.toLowerCase());
            }
        }
        
        return sb.toString();
    }

    public String solution2(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            int c = my_string.charAt(i);
            
            if (c >= 97 && c <= 122) {
                sb.append((char)(c - 32));
            } else if (c >= 65 && c <= 90) {
                sb.append((char)(c + 32));
            }
        }
        
        return sb.toString();
    }
}
