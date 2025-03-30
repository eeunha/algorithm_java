import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        int front = 0;

        while (front < progresses.length) {
            for (int i = front; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            if (progresses[front] < 100) continue;

            int cnt = 0;

            for (int i = front; i < progresses.length; i++) {
                if (progresses[i] < 100) break;
                
                cnt++;
                front++;
            }
            
            result.add(cnt);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}