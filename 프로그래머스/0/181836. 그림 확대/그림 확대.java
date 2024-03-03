class Solution {
    public String[] solution(String[] picture, int k) {

        int length = picture.length;
        String[] answer = new String[length * k];
        
        int index = 0;
        for (int i = 0; i < length; i++) {
            String curStr = picture[i];
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < curStr.length(); j++) {
                char curC = curStr.charAt(j);
                for (int h = 0; h < k; h++) {
                    sb.append(curC);
                }
            }
            
            for (int j = 0; j < k; j++) {
                answer[index] = sb.toString();
                index++;
            }
        }
        
        return answer;
    }
}