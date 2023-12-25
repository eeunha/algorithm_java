class Solution {
    public String[] solution(String my_str, int n) {
        int length = my_str.length();
        
        String[] answer = new String[(length % n == 0) ? length / n : length / n + 1];
        int idx = 0;
        
        for (int i = 0; i < length; i += n) {
            if (i + n < length) {
                answer[idx] = my_str.substring(i, i + n);  
                idx++;
            } else {
                answer[idx] = my_str.substring(i);
            }
        }
        
        return answer;
    }
}