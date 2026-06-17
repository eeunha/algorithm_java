/*
기사 - 1번부터 number 까지 번호 지정됨
무기점에서 무기 구매할 것
기사는 자신의 기사번호 "약수 개수"에 해당하는 "공격력"을 가진 무기 구매할 것
단, 공격력의 "제한수치" 정하고 제한수치보다 "큰" 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매해야함.

15번 기사단원
1, 3, 5, 15 > 4개 >> 공격력이 4인 무기 구매함.
만약, 제한수치가 3이고, 제한수치를 초과한 기사가 사용할 무기의 공격력이 2라면,
15번 기사단원은 공격력이 2인 무기를 구매함.

무기 만들 때 공격력 1당 1kg 철이 필요.
> 필요한 철의 무게 미리 계산.

무기를 모두 만들기 위한 철의 무게 구하기

I: int number, int limit, int power
O: int
C: 1 <= number(기사단원 수) <= 100000
    2 <= limit(공격력 제한수치) <= 100
    1 <= power(제한수치 초과한 기사의 무기 공격력) <= limit
E:

1부터 number까지 약수의 개수를 구하기
각 숫자의 약수의 개수와 공격력 제한수치 비교
    제한수치 이하 > 약수의 개수 그대로
    초과 > power 
비교했을때 각 공격력을 answer에 더하기

solution:

int answer = 0;
for (int i = 1; i <= number; i++) {
    
    int factorCnt = countFactors(i); // 현재 i의 약수의 개수 구하기
    
    // 약수의 개수와 limit 비교
    answer += (factorCnt <= limit) ? factorCnt : power;
}
return answer;

public int countFactors (int n) {
    if (n == 1) return 1;
    
    HashSet<Integer> set = new HashSet<>();
    
    for (int i = 1; i <= n / 2; i++) { >> 근데 범위를 제곱근까지 줄여도 가능
        if (n % i == 0) { // 나누어 떨어지는 경우 > 약수일 때
            set.add(i);
            set.add(n / i);
        }
    }
    
    return set.size();
}

time: O(N*sqrt(N))
space: O(1)
*/
class Solution {
    public int solution(int number, int limit, int power) {
        
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {

            int factorCnt = countFactors(i); // 현재 i의 약수의 개수 구하기

            // 약수의 개수와 limit 비교
            answer += (factorCnt <= limit) ? factorCnt : power;
        }
        
        return answer;
    }
    
    public int countFactors (int n) {

        int cnt = 0; // Integer > int 박싱과 set 중복 체크 오버헤드 제거

        for (int i = 1; i * i <= n; i++) { // Math로 매번 계산해야하는 오버헤드 제거
            if (n % i == 0) { // 나누어 떨어지는 경우 > 약수일 때
                if (i * i == n) {
                    cnt++; // 제곱근인 경우
                } else {
                    cnt += 2; // 일반적인 약수 쌍
                }
            }
        }

        return cnt;
    }
}