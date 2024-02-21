import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] edgesCount = new int[n + 1];
        Set<Integer> visitedNodeSet = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        
        // 연결관계 나타내는 맵 생성
        for (int[] e : edge) {
            int x = e[0];
            int y = e[1];
            
            Set<Integer> set = new HashSet<>();
            
            set = map.containsKey(x) ? map.get(x) : new HashSet<>(); 
            set.add(y);    
            map.put(x, set);
            
            set = map.containsKey(y) ? map.get(y) : new HashSet<>(); 
            set.add(x);    
            map.put(y, set);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        visitedNodeSet.add(1);
        queue.offer(1);
        
        while (queue.size() != 0) {
            int curNode = queue.poll(); // 현재 탐색할 노드
            
            //현재 노드와 연결된 다른 노드 추가하기
            for (int node : map.get(curNode)) {
                if (node != curNode && !visitedNodeSet.contains(node)) {
                    queue.offer(node);
                    visitedNodeSet.add(node);
                    
                    edgesCount[node] = edgesCount[curNode] + 1;
                    maxCount = Math.max(edgesCount[node], maxCount);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (edgesCount[i] == maxCount) {
                answer++;
            }
        }
        
        return answer;
    }
}