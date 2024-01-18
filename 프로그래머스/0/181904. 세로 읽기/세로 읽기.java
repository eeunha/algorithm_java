/*
i % m == 0 -> 새로운 줄의 시작

m=4, c=2
ihrh -> h -> 1 => (2-1) + m * 0 = 1 + 4 * 0 = 1
bakr -> a -> 5 => 1 + 4 * 1 = 5
fpnd -> p -> 9
oplj -> 
hygc

for (int i = 0; i < (my_string.length() - (c - 1)) / m; i++)
(c-1) + m * i

int curIdx = c - 1;
int i = 0;
while (curIdx < my_string.length()) {
    sb.append(my_string.charAt(curIdx));
    i++;
    curIdx += m * i;
}
*/
class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = c - 1; i < my_string.length(); i += m) {
            sb.append(my_string.charAt(i));
        }
        
        return sb.toString();
    }
}