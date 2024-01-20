import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        //edge cases
        if (numlist.length == 1) return numlist;
        
        int[] answer = new int[numlist.length];
        
        Arrays.sort(numlist);

        int nIndex = -1;
        int diff = Integer.MAX_VALUE;
        
        //기준값 찾기
        for (int i = 0; i < numlist.length; i++) {
            if (Math.abs(n - numlist[i]) < diff) {
                nIndex = i;
                diff = Math.abs(n - numlist[i]);
            }
        }
        
        answer[0] = numlist[nIndex];        
        int left = nIndex - 1;
        int right = nIndex + 1;
        
        int answerIdx = 1;
        
        while (answerIdx < answer.length) {
            if (left < 0) {
                answer[answerIdx] = numlist[right];
                right++;
            } else if (right >= numlist.length) {
                answer[answerIdx] = numlist[left];
                left--;
            } else {
                if (n - numlist[left] < numlist[right] - n) {
                    //왼쪽을 넣기
                    answer[answerIdx] = numlist[left];
                    left--;
                } else {
                    //오른쪽을 넣기
                    answer[answerIdx] = numlist[right];
                    right++;
                }
            }
            answerIdx++;
        }
        
        return answer;
    }
}