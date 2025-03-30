/*
I: String[] cards1, cards2, goal
O: String Yes / No
C: 1 ≤ cards1의 길이, cards2의 길이 ≤ 10
        1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
        cards1과 cards2에는 서로 다른 단어만 존재합니다.
    2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
        1 ≤ goal[i]의 길이 ≤ 10
        goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
    cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.
E:

ds:
algo:

pseudo:

time: O(N) N은 goal의 길이
space: O(1)
*/
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int idx1 = 0;
        int idx2 = 0;
        
        for (String s : goal) {
            if (idx1 < cards1.length && s.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < cards2.length && s.equals(cards2[idx2])) {
                idx2++;
            } else return "No";
        }
        
        return "Yes";
    }
}