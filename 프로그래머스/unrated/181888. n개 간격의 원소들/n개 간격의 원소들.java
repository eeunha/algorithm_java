import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        if (n == 1) return num_list;
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < num_list.length; i += n) {
            answer.add(num_list[i]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}