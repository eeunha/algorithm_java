class Solution {
    public String solution(String bin1, String bin2) {
        int sum = toNum(bin1) + toNum(bin2);
        return Integer.toBinaryString(sum);
    }
    
    public int toNum (String n) {
        int num = Integer.parseInt(n);
        int sum = 0;
        int count = 0;
        
        while (num > 0) {
            sum += Math.pow(2, count) * (num % 10);
            num /= 10;
            count++;
        }
        
        return sum;
    }
}