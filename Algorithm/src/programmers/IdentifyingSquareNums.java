package programmers;

public class IdentifyingSquareNums {
	public int solution(int n) {
		int sqrt = (int) Math.sqrt(n);
		return (sqrt * sqrt == n) ? 1 : 2;
	}
}
