class Solution {
    public boolean solution(String s) {
        int length = s.length();
        if (!(length == 4 || length == 6)) return false;
        
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) - 'A' >= 0) {
                return false;
            }
        }
        return true;
    }
}