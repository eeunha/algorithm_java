/*
I: String s
O: int[]
C: s의 길이는 1 이상 150,000 이하
    s에는 '1'이 최소 하나 이상 포함
E:
*/
class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        String x = s;
        
        while (!x.equals("1")) {
            int c = 0;
            
            //1. 0 제거 + 1의 개수(c) 세기
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    c++;
                }
            }
            answer[0]++;
            
            //2. c를 문자열로 변경하기
            String strC = Integer.toBinaryString(c);
            x = strC;
        }
            
        return answer;
    }
}