import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        System.out.println(BigInteger.TWO.pow(N).subtract(BigInteger.ONE));

        if(N <= 20){
            hanoi(N, 1, 2, 3);
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void hanoi(int N, int A, int B, int C) throws IOException {
        if(N == 1){
            bw.write(A + " " + C + "\n");
            return;
        }

        hanoi(N-1, A, C, B);
        hanoi(1, A, B, C);
        hanoi(N-1, B, A, C);
    }
}