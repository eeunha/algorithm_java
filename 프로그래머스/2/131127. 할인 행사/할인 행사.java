import java.util.*;

/*
I: String[] want, discount, int[] number
O: int
C: 1 ≤ want의 길이 = number의 길이 ≤ 10
        1 ≤ number의 원소 ≤ 10
        number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10
    10 ≤ discount의 길이 ≤ 100,000
    want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열
        1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12
E:

일정 금액 지불 시 10일간 회원 자격 부여.
회원 대상 매일 한 가지 제품 할인
할인상품은 하루에 하나만 구매 가능
내가 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 때 회원가입 예정

바나나 사과 쌀 돼지 냄비
0     0    0  0   0

치킨 사과 사과 바나나 쌀 사과 돼지 바나나 돼지 쌀 냄비 바나나 사과 바나나
 x       ^                                      ^

남은 개수: 0
시작일: 3
연속 일자: 10
answer: 1

ds: 해시맵
algo:

pseudo code:
구매목록 해시맵 생성 - <want[i], number[i]>
discount 순회
    10개씩 새로운 맵 생성
    두개의 맵이 같은지 비교
        같다면 answer 증가
answer 반환

time: O(N)
space: O(N)
*/
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();
            
            for (int j = 0; j < 10; j++) {
                discountMap.put(discount[i + j], discountMap.getOrDefault(discount[i + j], 0) + 1);
            }
            
            if (discountMap.equals(wantMap)) {
                answer++;
            }
        }
        
        return answer;
    }
}