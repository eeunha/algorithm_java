class Solution {
    public int solution(int[][] arr) {
        for (int i = 0; i < Math.ceil(arr.length / 2); i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }
        return 1;
    }
}