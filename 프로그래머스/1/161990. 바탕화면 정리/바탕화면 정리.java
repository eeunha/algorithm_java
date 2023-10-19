/*
I: String[] wallpaper
O: int[] {lux, luy, rdx, rdy}
C: 1 ≤ wallpaper의 길이 ≤ 50
    1 ≤ wallpaper[i]의 길이 ≤ 50, wallpaper의 모든 원소의 길이는 동일
    wallpaper[i][j]는 "#" 또는 "."의 값만
    바탕화면에는 적어도 하나의 파일이 있습니다.
    드래그 시작점 (lux, luy)와 끝점 (rdx, rdy)는 lux < rdx, luy < rdy를 만족해야 합니다.
E: 

빈칸은 .
파일이 있다면 #
해당 파일을 모두 포함할 수 있는, 최소한의 이동거리를 갖는 두 좌표 구하기

드래그 한 거리 = |rdx - lux| + |rdy - luy|
-> 
lux = 가장 작은 x값
luy = 가장 작은 y값
rdx = 가장 큰 x값
rdy = 가장 큰 y값

wallpaper 순회하면서 #인 경우만 좌표 확인

.#... -> 0,1
..#.. -> 1,2
...#. -> 2,3
x -> 0,1,2 -> min=0, max=2
y -> 1,2,3 -> min=1, max=3
return {0, 1, 3, 4} 2+1, 3+1

..........
.....#.... -> 1,5
......##.. -> 2,6, 2,7
...##..... -> 3,3, 3,4
....#..... -> 4,4
x -> 1,2,3,4 -> min=1, max=4
y -> 3,4,5,6,7 -> min=3, max=7
return {1, 3, 5, 8}

return {minX, minY, maxX+1, maxY+1}

만약 파일이 하나라면
{x, y, x+1, y+1}

solution:
int[] answer = new int[4];
for (int i = 0; i < answer.length; i++) {
    for (int j = 0; j < answer[0].length; j++) {
    
    }
}
return answer;

time: O(NM)
space: O(1)
*/
class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                char curPos = wallpaper[i].charAt(j);
                if (curPos != '#') continue;
                
                // 파일이 있는 경우
                minX = Math.min(minX, i);
                minY = Math.min(minY, j);
                maxX = Math.max(maxX, i);
                maxY = Math.max(maxY, j);
            }
        }  
         
        return new int[]{minX, minY, maxX + 1, maxY + 1};
    }
}