/*
I: String word
O: int
C: word의 길이는 1 이상 5 이하
    word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
E: 

A = 1, E = 2, I = 3, O = 4, U = 5 ?
A -> 1
AAAAA -> 5
AAAAE -> 1 + 1 + 1 + 1 + 2 = 6
AAAE  -> 1 + 1 + 1 + 2 + 5 = 10
AAE -> 1 + 1 + 2 + 12 = 16

A -> 1
E -> 1564/2 = 782
I -> 1563

|AAAAA - AAAAE| = 1
|AAAA - AAAE| = 6
|AAA - AAE| = 

ds:
algo:

time:
space:
*/

import java.util.*;

class Solution {
    ArrayList<String> list;
    String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        list = new ArrayList<>();
        
        //자리수 지정
        for (int i = 1; i <= 5; i++) {
            makeWord(i, new StringBuilder());
        }
        
        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
    
    public void makeWord(int length, StringBuilder sb) {
        if (sb.length() == length) {
            list.add(sb.toString());
        } else {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                makeWord(length, sb);
                sb.deleteCharAt(sb.length() - 1);
            }            
        }
    }
}