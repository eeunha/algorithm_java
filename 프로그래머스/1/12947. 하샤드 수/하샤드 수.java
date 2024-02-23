class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int curX = x;
        
        while (curX > 0) {
            sum += curX % 10;
            curX /= 10;
        }
        
        return (x % sum == 0) ? true : false;
    }
}