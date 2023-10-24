class Solution {
    public String[] solution(String my_string) {
        my_string = my_string.replaceAll("\\s+", " ").trim();
        return my_string.split(" ");
    }
}