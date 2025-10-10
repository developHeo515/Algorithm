import java.io.*;
import java.util.StringTokenizer;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] bread = new int[N * K];
        int answer = N;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N * K; i++) {
            bread[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int noCreamCount = 0;

            for (int j = 0; j < K; j++) {
                if (bread[i * K + j] == 0){
                    noCreamCount++;
                }
            }

            if (noCreamCount >= P){
                answer--;
            }
        }

        sb.append(answer);
        System.out.println(sb.toString());
    }
}