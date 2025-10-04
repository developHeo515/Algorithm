import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int res = ((N % 4 == 0 && N % 100 != 0) || N % 400 == 0) ? 30 : 29;

        System.out.println(res);
    }
}