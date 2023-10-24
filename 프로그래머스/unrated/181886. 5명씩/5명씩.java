class Solution {
    public String[] solution(String[] names) {
        int length = names.length;
        int n = (length % 5 == 0) ? length / 5 : length / 5 + 1;
        
        String[] answer = new String[n];
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            answer[i] = names[idx];
            idx += 5;
        }
        
        return answer;
    }
}