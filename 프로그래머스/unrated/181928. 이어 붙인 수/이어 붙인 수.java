class Solution {
    public int solution(int[] num_list) {
        StringBuilder sb_even = new StringBuilder();
        StringBuilder sb_odd = new StringBuilder();
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                sb_even.append(num_list[i]);
            } else {
                sb_odd.append(num_list[i]);
            }
        }
        return Integer.parseInt(sb_odd.toString()) + Integer.parseInt(sb_even.toString());
    }
}