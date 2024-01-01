/*
I: int chicken
O: int
C: chicken은 정수, 0 <= chicken <= 1000000
E: chicken < 10, return 0;

chicken = 100
서비스 치킨 = 10마리
-> 또 서비스 치킨 1마리 추가
=> 총 11마리

chicken = 1081
서비스치킨 수 = 1081 / 10 = 108마리
현재 치킨 수 = 108 + 1 = 109마리

서비스치킨 수 = 108 + 109 / 10 = 108 + 10 = 118마리
현재 치킨 수 109 / 10 + 109 % 10 = 10 + 9 = 19마리

100 - 10 => 1 추가 => 91마리
91 - 10 => 1마리 추가 => 82마리

time:
space:
*/
class Solution {
    public int solution(int chicken) {
        if (chicken < 10) return 0;
        int result = 0;
        
        while (chicken > 9) {
            chicken = chicken - 9;
            result++;
        }
        
        return result;
    }
}