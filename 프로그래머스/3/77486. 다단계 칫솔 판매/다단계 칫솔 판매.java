import java.util.*;

/*
I: String[] enroll 판매원 이름, referral 부모 판매원, seller 판매원, int[] amount 판매수량
O: int[]
C: 판매원에게 배분된 이익금의 총합을 계산하여(정수형으로), 입력으로 주어진 enroll에 이름이 포함된 순서에 따라 나열
    
E:

모든 판매원은 칫솔의 판매에 의하여 발생하는 이익에서 10% 계산하여
자신을 조직에 참여시킨 추천인에게 배분하고
나머지는 자신이 가진다.

모든 판매원은 자신이 칫솔 판매에서 발생한 이익 뿐만 아니라
자신이 조직에 추천하여 가입시킨 판매원에게서 발생하는 이익의 10%까지 자신에 이익이 된다.

자신에게 발생하는 이익 또한 자신의 추천인에게 분배된다.

단, 10% 계산 시 원 단위에서 절사.
10% 계산 금액이 1원 미만인 경우 자신이 다 가짐
칫솔 1개 판매 시 이익은 100원 (개당 100원)

이진트리가 아니라 배열은 어려울듯. 다른 자료구조 필요함.
근데 다른 구조 필요하지 않은데? 어차피 부모만 알면 되는거 아니야?

맵 > (판매자, 금액)

pseudo:
판매자와 판매수량을 순회한다.
판매자의 부모가 없을 때까지 현재 이익을 모두 계산한다.
판매자가 부모가 있는지 확인한다.
    있다면 이익의 10%를 차하고 판매자가 이익을 갖는다. 그리고 부모에게 10% 이익을 넘겨준다.
    없다면 자신이 모든 이익을 갖는다.
    (이익금은 맵에 저장한다.) 
enroll을 순회하면서 결과 배열에 수익을 넣는다.

time: O(N*M)
space: O(N)
*/
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // 이름, 이익 맵
        HashMap<String, Integer> profitMap = new HashMap<>();
        
        //이름, 부모이름 맵
        HashMap<String, String> parentMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
        }

        // 이익 계산
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int profit = amount[i] * 100;
            
            while (profit > 0 && !sellerName.equals("-")) {
                
                profitMap.put(sellerName, profitMap.getOrDefault(sellerName, 0) + profit - (profit / 10));
                // 10퍼 이익을 다음 반복에 넘기기
                profit /= 10;
                    
                // 참조 판매원 이름을 다음 반복에 넘기기
                sellerName = parentMap.get(sellerName);
            }
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.getOrDefault(enroll[i], 0);        
        }
        
        return answer;
    }
}