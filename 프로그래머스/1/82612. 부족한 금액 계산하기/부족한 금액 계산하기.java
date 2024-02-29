class Solution {
    public long solution(int price, int money, int count) {
        long curPrice = 0;
        
        for (int i = 1; i <= count; i++) {
            curPrice += price * i;
        }
        
        return (curPrice <= money) ? 0 : curPrice - money;
    }
}