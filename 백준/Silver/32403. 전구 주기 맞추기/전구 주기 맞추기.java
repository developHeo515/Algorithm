import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int T = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(secondLine[i]);
        }

        int answer = 0;

        for (int a : A) {
            int num = 0;
            while (true) {
                if (T % (a + num) == 0) {
                    break;
                } else if (T % (a - num) == 0 && (a - num) > 0) {
                    break;
                } else {
                    num++;
                }
            }
            answer += num;
        }

        bw.write(String.valueOf(answer));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}