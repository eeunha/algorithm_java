import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger bA = new BigInteger(a);
        BigInteger bB = new BigInteger(b);
        BigInteger sum = bA.add(bB);
        return sum + "";
    }
}