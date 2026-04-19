import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> hm = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            String s = String.valueOf(i);
            hm.put(str, s);
            hm.put(s, str);
        }

        for(int i = 0; i < M; i++){
            String solve = br.readLine();
            bw.write(hm.get(solve) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}