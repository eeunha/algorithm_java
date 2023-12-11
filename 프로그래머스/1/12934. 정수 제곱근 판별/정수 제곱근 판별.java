class Solution {
    public long solution(long n) {
        String sqrtNStr = Math.sqrt(n) + "";
		int dotIndex = sqrtNStr.indexOf(".");
		if (sqrtNStr.substring(dotIndex + 1).length() > 1) {
			return -1;
		}
		long l = Long.valueOf(sqrtNStr.substring(0, dotIndex)) + 1;
		return l * l;
    }
}