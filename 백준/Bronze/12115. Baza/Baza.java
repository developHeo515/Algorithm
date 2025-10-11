import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), m = read();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) mat[i][j] = read();

        int q = read();
        while (q-- > 0) {
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) arr[i] = read();

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int k = 0;
                for (int j = 0; j < m; j++) if (arr[j] == -1 || arr[j] == mat[i][j]) k++;
                if (k == m) cnt++;
            }
            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}