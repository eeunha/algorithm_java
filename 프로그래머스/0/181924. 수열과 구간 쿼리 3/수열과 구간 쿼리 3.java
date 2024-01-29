/*
0 1 2 3 4
0 3 -> 3 1 2 0 4
1 2 -> 3 2 1 0 4
1 4 -> 3 4 1 0 2
*/
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int temp;
        
        for (int i = 0; i < queries.length; i++) {
            temp = arr[queries[i][0]];
            arr[queries[i][0]] = arr[queries[i][1]];
            arr[queries[i][1]] = temp;
        }
        
        return arr;
    }
}