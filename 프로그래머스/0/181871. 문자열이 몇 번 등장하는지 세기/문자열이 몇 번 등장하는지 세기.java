class Solution {
    public int solution(String myString, String pat) {
        //edge case
        if (myString.length() < pat.length()) return 0;
        
        int answer = 0;
        int pLength = pat.length();
        
        for (int i = 0; i <= myString.length() - pLength; i++) {
            if (myString.substring(i, i + pLength).equals(pat)) {
                answer++;
            }
        }
        
        return answer;
    }
}