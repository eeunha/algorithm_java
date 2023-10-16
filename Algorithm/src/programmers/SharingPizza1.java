package programmers;

//피자 나눠 먹기 (1)
/*

1~7 명 -> 피자 1판 7/7 = 1
8~14명 -> 피자 2판 14/7 = 2

if (n / 7 == 0) return (int) (n / 7);
else return (int) (n / 7) + 1;
*/
public class SharingPizza1 {
	public int solution(int n) {
        return (n % 7 == 0) ? (int) (n / 7) : (int) (n / 7) + 1;
    }
}
