import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        Set<Integer> set = new HashSet<>();
        set.add(N);
        map.put(1, set);
        
        for (int i = 2; i <= 8; i++) {
            set = new HashSet<>();
            int curN = N;
            for (int j = 1; j < i; j++) {
                curN += N * Math.pow(10, j);
                System.out.println(curN);
            }
            set.add(curN);
            
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int n1 : map.get(j)) {
                    for (int n2 : map.get(k)) {
                        set.add(n1 + n2);
                        set.add(n1 - n2);
                        set.add(n1 * n2);
                        if (n2 != 0) {
                            set.add(n1 / n2);    
                        }
                    }
                }
            }
            if (set.contains(number)) {
                return i;
            }
            
            map.put(i, set);
        }
        
        return -1;
    }
}