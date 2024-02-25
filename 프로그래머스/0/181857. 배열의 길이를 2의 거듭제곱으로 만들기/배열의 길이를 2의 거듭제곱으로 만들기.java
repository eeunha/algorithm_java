class Solution {
    public int[] solution(int[] arr) {
        
        int length = arr.length;
        int count = 0;
        boolean flag = true;
        
        while (length > 1) {
            if (length % 2 == 1) {
                flag = false;
            }
            
            length /= 2;
            count++;
        }
       
        count = (!flag) ? (int) Math.pow(2, count + 1) : (int) Math.pow(2, count);    
        
        int[] answer = new int[count];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (i < arr.length) ? arr[i] : 0;
        }        
        
        return answer;
    }
}