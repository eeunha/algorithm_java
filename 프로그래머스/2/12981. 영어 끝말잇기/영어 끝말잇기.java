import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int idx = 1;
        String word = words[0];
        char lastChar = word.charAt(word.length() - 1);
        
        Set<String> set = new HashSet<>();
        set.add(word);
        
        while (idx < words.length) {
            int curIdx = idx % n;
            String curWord = words[idx];
            
            if (lastChar == curWord.charAt(0) && !set.contains(curWord)) {
                // 이어서
                idx++;
                lastChar = curWord.charAt(curWord.length() - 1);
                set.add(curWord);
            } else {
                // 탈락
                answer[0] = curIdx + 1;
                answer[1] = idx / n + 1;
                break;
            }
        }

        return answer;
    }
}