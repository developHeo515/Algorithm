import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());

        String[] bStr = br.readLine().split(" ");
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(bStr[i]));
        }

        List<Integer> result = new ArrayList<>();
        int i = 0;

        while (i < m) {
            result.add(b.get(i));
            i += b.get(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < result.size(); j++) {
            sb.append(result.get(j));
            if (j < result.size() - 1) {
                sb.append(" ");
            }
        }
        bw.write(sb.toString());
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}