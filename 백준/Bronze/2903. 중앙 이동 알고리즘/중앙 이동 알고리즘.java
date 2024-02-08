import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int block = 1;
        
        for (int i = 1; i <= n; i++) {
            block *= 2;
        }
        
        bw.write(String.valueOf((block + 1) * (block + 1)));
        bw.flush();
        bw.close();
    }
}