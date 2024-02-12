class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i); 
            int idx = c - 'a';
            if (idx < 0) {
                // 대문자인 경우
                answer[c - 'A']++;    
            } else {
                // 소문자인 경우
                answer[c - 'a' + 26]++;
            }
        }
        
        return answer;
    }
}