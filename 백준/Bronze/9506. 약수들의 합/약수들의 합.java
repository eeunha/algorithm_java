import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int input = Integer.parseInt(br.readLine());
			sb.setLength(0);
			sb.append(input + " = 1");

			if (input == -1) {
				break;
			}

			int sum = 1;
			for (int i = 2; i <= input / 2; i++) {
				if (input % i == 0) {
					sum += i;
					sb.append(" + " + i);
				}
			}

			if (sum == input) {
				bw.write(sb.toString() + "\n");
			} else {
				bw.write(input + " is NOT perfect.\n");
			}

			bw.flush();
		}

		bw.close();
	}
}