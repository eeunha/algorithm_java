class Solution {
    public int solution(int n) {
        
        //n의 이진수 변환 후 1의 개수 세기
        int count1 = Integer.bitCount(n);
        
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            //i의 이진수 변환 후 1의 개수 세기
            
            if (Integer.bitCount(i) == count1) {
                return i;
            }
        }
        
        return -1;
    }
}