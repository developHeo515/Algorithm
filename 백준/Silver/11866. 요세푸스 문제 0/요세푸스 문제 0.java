import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        int idx = 0;
        bw.write("<");
        while(!q.isEmpty()){
            idx++;
            int num = q.poll();

            if(idx == K){
                idx = 0;
                if(q.size() == 0){
                    bw.write(num + "");
                }
                else
                    bw.write(num + ", ");
            }
            else {
                q.offer(num);
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}