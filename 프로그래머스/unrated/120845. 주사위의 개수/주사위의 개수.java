//time: O(1)
//space: O(1)
class Solution {
    public int solution(int[] box, int n) {
        return (int) (box[0] / n) * (int) (box[1] / n) * (int) (box[2] / n);
    }
}