import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int cnt = 0;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

//        System.out.println(BigInteger.TWO.pow(N).subtract(BigInteger.ONE));
        bw.write((int)Math.pow(2, N) - 1 + "\n");

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
        bw.write(A + " " + C + "\n");
        hanoi(N-1, B, A, C);
    }
}