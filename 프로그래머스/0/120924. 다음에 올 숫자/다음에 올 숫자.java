class Solution {
    public int solution(int[] common) {
        
        if (common[1] - common[0] == common[2] - common[1]) {
            //등차인 경우
            return common[common.length - 1] + (common[1] - common[0]);
        } 
        
        return common[common.length - 1] * (common[1] / common[0]);
    }
}