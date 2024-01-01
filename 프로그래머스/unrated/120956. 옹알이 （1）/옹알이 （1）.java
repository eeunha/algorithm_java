class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        boolean flag = true;
        
        for (int i = 0; i < babbling.length; i++) {
            String curStr = babbling[i];
            flag = true;
            
            for (int j = 0; j < curStr.length(); j++) {
                if (curStr.substring(j).length() > 2) {
                    //System.out.println("3자리: " + curStr.substring(j, j + 3));
                    if (curStr.substring(j, j + 3).equals("aya") || curStr.substring(j, j + 3).equals("woo")) {
                        
                        j += 2;
                        continue;
                    }
                }
                if (curStr.substring(j).length() > 1) {
                    //System.out.println("2자리: " + curStr.substring(j, j + 2));
                    if (curStr.substring(j, j + 2).equals("ye") || curStr.substring(j, j + 2).equals("ma") ) {
                        j++;
                        continue;
                    }
                    
                    flag = false;
                    break;
                    
                } else {
                    //System.out.println("1자리: " + curStr.substring(j));
                    flag = false;
                    break;
                }
            }
            //System.out.println(flag);
            if (flag) {
                answer++;
            }
            
            //System.out.println();
        }
        
        return answer;
    }
}