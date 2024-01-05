class Solution {
    public int solution(String A, String B) {
        //edge cases
        if (A.equals(B)) return 0;
        if (A.length() == 1) return -1;
        
        StringBuilder sb = new StringBuilder();
        
        int answer = -1;
  
        for (int i = A.length() - 1; i >= 0; i--) {
            sb = new StringBuilder();
            sb.append(A.substring(i));
            sb.append(A.substring(0, i));
            
            if (sb.toString().equals(B)) {
                return A.length() - i;
            }
        }
        
        return  answer;
    }
}