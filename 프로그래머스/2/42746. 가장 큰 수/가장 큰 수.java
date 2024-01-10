/*
I: int[] numbers
O: String
C: numbers의 길이는 1 이상 100,000 이하
    numbers의 원소는 0 이상 1,000 이하
    정답이 너무 클 수 있으니 문자열로 바꾸어 return
E: numbers.length == 1 -> return numbers[0]+""

[6, 10, 2] -> [6, 2, 10] => "6210"
[3, 30, 34, 5, 9] -> [9, 5, 34, 3, 30] => "9534330"

내가 원하는 대로 정렬 시키기
numbers를 index=0 부터 순회하면서 stringbuilder에 append()
stringbuilder.toString() 반환

ds: array
algo: sort

time:  O(n log n) -> n = numbers.length
space: O(N)
*/
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        //edge cases
        if (numbers.length == 1) return numbers[0] + "";
        
        StringBuilder sb = new StringBuilder();
        
        Integer[] nums = new Integer[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }

        // 퀵 정렬 기반
        Arrays.sort(nums, (n1, n2) -> {
            String a = n1 + "";
            String b = n2 + "";
            
            String n1n2 = a + b;
            String n2n1 = b + a;
            
            return n2n1.compareTo(n1n2);
        });
        
        for (int n : nums) {
            sb.append(n);
        }
        
        String str = sb.toString().replaceAll("0", "");
        
        return str.equals("") ? "0" : sb.toString();
    }
}