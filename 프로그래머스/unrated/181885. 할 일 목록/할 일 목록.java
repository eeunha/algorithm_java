/*
I: String[] todo_list, boolean{} finished
O: String[]
C: 1 ≤ todo_list의 길이 1 ≤ 100
    2 ≤ todo_list의 원소의 길이 ≤ 20
        todo_list의 원소는 영소문자로만 이루어져 있습니다.
        todo_list의 원소는 모두 서로 다릅니다.
    finished[i]는 true 또는 false이고 true는 todo_list[i]를 마쳤음을, false는 아직 마치지 못했음을 나타냅니다.
    아직 마치지 못한 일이 적어도 하나 있습니다.
E: 

solution:

time:
space:
*/
import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int count = 0;
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) count++;
        }
        String[] result = new String[count];
        
        int idx = 0;
        
        
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) result[idx++] = todo_list[i];
        }
            
        return result;
    }
}