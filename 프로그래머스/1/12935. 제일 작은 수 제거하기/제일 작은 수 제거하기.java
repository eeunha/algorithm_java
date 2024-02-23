class Solution {
    public int[] solution(int[] arr) {
        //edge case
        if (arr.length == 1) return new int[]{-1};
        
        int[] answer = new int[arr.length - 1];
        
        int idx = -1;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                idx = i;
                min = arr[i];
            } 
        }
        
        for (int i = 0, arrIdx = 0; i < arr.length; i++) {
            if (i == idx) {
                continue;
            }
            answer[arrIdx] = arr[i];
            arrIdx++;
        }

        return answer;
    }
}