import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < score.length; i++) {
            int sum = score[i][0] + score[i][1];
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                queue.add(sum);
                map.put(sum, 1);
            }
        }
        
        int rank = 1;
        while (queue.size() > 0) {
            int curSum = queue.poll();
            int curCount = map.get(curSum);
            
            for (int i = 0; i < score.length && curCount > 0; i++) {
                if (answer[i] != 0 || score[i][0] + score[i][1] != curSum) continue;
                answer[i] = rank;
                curCount--;
            }
            
            rank += map.get(curSum);
        }
        
        return answer;
    }
}