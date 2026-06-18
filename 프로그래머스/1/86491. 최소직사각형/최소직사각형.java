/*
지갑의 크기 정하기
다양한 모양과 크기의 명함들 모두 수납 가능
작아서 들고다니기 편함
가로 세로 길이 조사함

I: int[][] sizes
O: int 지갑의 크기(넓이)
C: 1 <= sizes.length <= 10000
    sizes[i] = [w, h]
    w = 가로길이
    h = 세로길이
    1 <= w, h <= 1000 자연수
E: sizes.length == 1 > return sizes[0][0] * sizes[0][1];

ds: array
algo: brute force

가로와 세로를 바꿔도 됨
> 가로 세로 봤을 때 작은 값을 [0]으로, 큰 값을 [1] 로 바꾸기
바꾼 sizes 순회하면서 [0]과 [1] 각각 가장 큰 값 찾기
두 큰 값을 곱해서 반환

solution:
for (int i = 0; i < sizes.length; i++) {
    if (sizes[i][0] > sizes[i][1]) {
        int t = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = t;
    }
}

int maxW = sizes[0][0];
int maxH = sizes[0][1];

for (int[] size : sizes) {
    maxW = Math.max(maxW, size[0]);
    maxH = Math.max(maxW, size[1]);
} > 위의 for문으로 합칠 수 있음. >> 아래 코드에서 합칠 것
return  maxW * maxH;

time: O(N) N = sizes.length
space: O(1)
*/
class Solution {
    public int solution(int[][] sizes) {
        // edge case
        if (sizes.length == 1) {
            return sizes[0][0] * sizes[0][1];
        }
        
        int maxW = 0;
        int maxH = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                int t = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = t;
            }
            
            maxW = Math.max(maxW, sizes[i][0]);
            maxH = Math.max(maxH, sizes[i][1]);
        }

        return  maxW * maxH;
    }
}