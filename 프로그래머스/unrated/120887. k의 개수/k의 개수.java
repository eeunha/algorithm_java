/*
I: int i, j, k
O: int
C: 
E: 

time:
space:
*/
class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for (int curI = i; curI <= j; curI++) {
            String curIStr = curI + "";
            String[] arr = curIStr.split("");
            for (String s : arr) {
                if (s.equals(k + "")) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}