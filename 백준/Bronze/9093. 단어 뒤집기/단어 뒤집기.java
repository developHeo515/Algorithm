import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < n; tc++){
            Deque<String> stack = new ArrayDeque<>();
            String answer = "";
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String str = st.nextToken();
                for(int i = str.length() - 1; i >= 0; i--){
                    answer += str.charAt(i);
                }
                answer += " ";
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}