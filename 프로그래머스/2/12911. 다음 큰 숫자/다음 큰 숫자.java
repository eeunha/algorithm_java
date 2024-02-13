class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //n의 이진수 변환 후 1의 개수 세기
        String strN = Integer.toBinaryString(n);
        int count1 = 0;
        
        for (int i = 0; i < strN.length(); i++) {
            if (strN.charAt(i) == '1') {
                count1++;
            }
        }
        
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            //i의 이진수 변환 후 1의 개수 세기
            String strI = Integer.toBinaryString(i);
            int count2 = 0;
            
            for (int j = 0; j < strI.length(); j++) {
                if (strI.charAt(j) == '1') {
                    count2++;
                }
            }
            
            if (count1 == count2) {
                return i;
            }
        }
        return answer;
    }
}