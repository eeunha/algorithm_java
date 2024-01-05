class Solution {
    public int solution(String A, String B) {
        //edge cases
        if (A.equals(B)) return 0;
        if (A.length() == 1) return -1;
        
        String str = B.repeat(3);
        
        return str.indexOf(A);
    }
}