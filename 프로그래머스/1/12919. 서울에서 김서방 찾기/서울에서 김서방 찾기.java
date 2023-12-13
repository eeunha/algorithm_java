class Solution {
    public String solution(String[] seoul) {
        //edge cases
        if (seoul.length == 1) return "김서방은 0에 있다";
        
        String answer = "";
        
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
       
        return answer;
    }
}