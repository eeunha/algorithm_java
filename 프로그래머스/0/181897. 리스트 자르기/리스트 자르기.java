import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList<>();
        
        int start = (n == 1) ? 0: slicer[0];
        int end = (n == 2) ? num_list.length - 1 : slicer[1];
        int add = (n == 4) ? slicer[2] : 1 ;
        
        for (int i = start; i <= end; i += add) {
                list.add(num_list[i]);
            }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}