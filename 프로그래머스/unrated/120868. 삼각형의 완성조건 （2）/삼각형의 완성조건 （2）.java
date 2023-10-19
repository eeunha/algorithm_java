/*
I: int[]
O: int - 한 변이 될 수 있는 정수의 개수
C: sides의 원소는 자연수
    sides의 길이는 2
    1 ≤ sides의 원소 ≤ 1,000
E:

가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
c < a+b

두 변이 주어지고, 다른 한 변의 길이를 정해야 한다.
남은 한 변은 가장 긴 변일수도 있고 아닐 수도 있다.
두 경우에 공통으로 들어가는 수의 개수를 센다.

[1, 2] c=?
1. c가 가장 긴 변인 경우
c < 1+2 -> c = 1, 2
2. c가 가장 긴 변이 아닌 경우
max(1, 2) < min(1,2) + c
2 < 1+c -> 2-1 < c -> 1 < c

두 경우가 공통인 개수 세기
max(a, b) - min(a, b) < c < a+b

ex2)
[3,6], c=?
6-3 < c < 3+6
3 < c < 9
9 - 3 - 1

solution:
a+b - |a-b| - 1
sides[0] + sides[1] - Math.abs(sides[0] - sides[1]) - 1

time: O(1)
space: O(1)
*/
class Solution {
    public int solution(int[] sides) {
        return sides[0] + sides[1] - Math.abs(sides[0] - sides[1]) - 1;
    }
}