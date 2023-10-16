package programmers;

/*
양꼬치 

I: int n, k
O: int
C: 0 < n < 1,000
    n / 10 ≤ k < 1,000
    서비스로 받은 음료수는 모두 마십니다.
E: k == 0 -> return n * 12000

solution: 
10인분 -> 음료수 1개
서비스 음료수 개수 = n/10
n * 12000 + (n - (int) (n/10)) * 2000

time: O(1)
space: O(1)
*/
public class LambTikka {
	public int solution(int n, int k) {
		return n * 12000 + (k - (int) (n / 10)) * 2000;
	}
}
