package programmers;

public class DupString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "He11oWor1d";
		String b = "lloWorl";
		int s = 2;
		System.out.println(solution(a, b, s));
	}

	public static String solution(String my_string, String overwrite_string, int s) {
		// edge cases
		if (overwrite_string.length() == my_string.length())
			return overwrite_string;

		// stringbuilder sb 생성
		StringBuilder sb = new StringBuilder();

		// 시작 ~ s 이전 인덱스까지 sb에 my_string을 append
		sb.append(my_string.substring(0, s));
		System.out.println(sb);

		// s ~ s+overwrite_string.length()-1 까지 sb에 overwrite_string을 append
		// sb.append(overwrite_string.substring(s, overwrite_string)) // 바로 문자열 넣으면 된다.
		// 잘라서 계산할 필요가 없다.
		sb.append(overwrite_string);

		// 끝 문자열이 남은 경우만 추가로 my_string을 append
		if (my_string.length() - 1 > s + overwrite_string.length() - 1) { // 기존 문자열이 더 긴 경우
			sb.append(my_string.substring(s + overwrite_string.length() - 1));
		}

		return sb.toString();
	}
}
