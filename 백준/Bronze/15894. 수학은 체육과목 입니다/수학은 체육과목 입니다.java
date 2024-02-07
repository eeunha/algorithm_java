import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Long n = Long.parseLong(br.readLine());
        
        bw.write(String.valueOf(4 * n));
        bw.flush();
        bw.close();
    }
}
