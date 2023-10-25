import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int n : delete_list) {
            set.add(n);
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) list.add(arr[i]);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}