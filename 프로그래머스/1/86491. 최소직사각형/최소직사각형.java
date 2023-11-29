/*
I: int[][] sizes
O: 지갑의 크기(가로 * 세로)
C: sizes의 길이는 1 이상 10,000 이하
   sizes의 원소는 [w, h] 형식
   w는 명함의 가로 길이
   h는 명함의 세로 길이
   w와 h는 1 이상 1,000 이하인 자연수
E: sizes.length == 1 -> return sizes[0][0] * sizes[0][1];

지갑의 크기 정하기.
명함의 가로와 세로 길이 확인
모든 명함을 수납할 수 있는 가장 작은 지갑 만들기
-> 가장 큰 가로와 세로 길이 찾기

time: O(n), n = sizes.length
space: O(1)
*/
class Solution {
    public int solution(int[][] sizes) {
        //edge cases
        if (sizes.length == 1) return sizes[0][0] * sizes[0][1];
        
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        
        for (int i = 0; i < sizes.length; i++) {
            int curW = sizes[i][0];
            int curH = sizes[i][1];
            
            if (sizes[i][0] < sizes[i][1]) {
                curW = sizes[i][1];
                curH = sizes[i][0];
            }
            
            maxW = (maxW < curW) ? curW : maxW;
            maxH = (maxH < curH) ? curH : maxH;
        }
        
        return maxW * maxH;
    }
}