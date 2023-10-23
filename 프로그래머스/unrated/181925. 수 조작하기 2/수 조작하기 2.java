/*
I: int[] numLog
O: String
C: 2 ≤ numLog의 길이 ≤ 100,000
    -100,000 ≤ numLog[0] ≤ 100,000
    1 ≤ i ≤ numLog의 길이인 모든 i에 대해 |numLog[i] - numLog[i - 1]|의 값은 1 또는 10입니다.
E: numLog.length == 1 -> return ""

+1 -> w
-1 -> s
+10 -> d
-10 -> a

for (int i = 1; i < numLog.length; i++) {
    int diff = numLog[i] - numLog[i - 1];
    if (diff == 1) {
        sb.append("w");
    } else if (diff == -1) {
        sb.append("s");
    } else if (diff == 10) {
        sb.append("d");
    } else {
        sb.append("a");
    }
}

solution:

time: O(N)
space: O(1)
*/
class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            if (diff == 1) {
                sb.append("w");
            } else if (diff == -1) {
                sb.append("s");
            } else if (diff == 10) {
                sb.append("d");
            } else {
                sb.append("a");
            }
        }
        
        return sb.toString();
    }
}