class Solution {
    public int[] solution(int[] num_list) {
        int numLen = num_list.length;
        
        int[] answer = new int[numLen + 1];
        
        for (int i = 0; i < numLen; i++) {
            answer[i] = num_list[i];
        }
        
        answer[numLen] = (num_list[numLen - 2] < num_list[numLen - 1]) ? num_list[numLen - 1] - num_list[numLen - 2] : 2 * num_list[numLen - 1];
        
        return answer;
    }
}