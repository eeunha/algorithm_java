import java.util.HashSet;

/*
I: String
O: int
C: dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
   dirs의 길이는 500 이하의 자연수 
   단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
E: dirs의 길이가 1인 경우 무조건 답은 1

0,0 > 0,1 > -1,1 > -1,2 > 0,2 > 1,2 > 1,1 > 0,1 > -1,1 > -1,2
5,5 > 5,6 > 4,6 > 4,7 > 5,7 > 6,7 > 6,6 > 5,6 > 4,6 > 4,6 (위에서 +5 됨)


ds: HashSet, array
algo:

pseudo:
    dirs를 순회한다
    각 값을 읽어 이동시키려 한다.
        만약 이동시키려는 값이 좌표평면을 벗어나면 이동시키지 않고 그자리에 있는다.
        벗어나지 않는다면 이동시킨다
            이동시키면서 시작점과 이동점을 문자열로 합쳐 셋에 저장한다.
    셋의 크기를 반환한다.

time: O(N) N은 dirs의 개수
space: O(N) N은 dirs의 개수

solution:

*/
class Solution {
    public int solution(String dirs) {
        
        int x = 0;
        int y = 0;
        
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) { //O(N)
           
            int[] newDir = changeDir(x, y, dirs.charAt(i)).clone();
            
            if (correctDir(newDir[0], newDir[1])) {
                String reverseStr = "" + newDir[0] + newDir[1] + x + y;
                if (!set.contains(reverseStr)) {
                    set.add("" + x + y + newDir[0] + newDir[1]);
                }
                
                x = newDir[0];
                y = newDir[1];
            }
        }
        
        return set.size();
    }
    
    public int[] changeDir(int x, int y, char dir) {
        
        if (dir == 'U') { // y++
                y++;
        } else if (dir == 'D') { // y--
            y--;
        } else if (dir == 'L') { // x--
            x--;
        } else { // x++
            x++;
        }
        
        return new int[]{x, y};
    }
    
    public boolean correctDir(int x, int y) {
        if (x > 5 || x < -5 || y > 5 || y < -5) {
            return false;
        }
        return true;
    }
    
}
