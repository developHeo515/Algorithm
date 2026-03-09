import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int time;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = 0;
        visited = new boolean[100000+1];
        bfs();

        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        if(N == K) return;

        Queue<Integer> q = new ArrayDeque<>();
        visited[N] = true;
        q.offer(N);
        boolean flag = false;

        while(!q.isEmpty()){
            int qsize = q.size();

            while(qsize-- != 0){
                int cur = q.poll();
//                System.out.print(cur + " ");
                if(cur == K) {
                    flag = true;
                    break;
                }


                if(cur + 1 <= 100000 && !visited[cur + 1]) {
                    visited[cur+1] = true;
                    q.offer(cur + 1);
                }
                if(cur - 1 >= 0 && !visited[cur - 1]) {
                    visited[cur-1] = true;
                    q.offer(cur - 1);
                }
                if(cur * 2 <= 100000 && !visited[cur * 2]) {
                    visited[cur*2] = true;
                    q.offer(cur * 2);
                }
            }
            if(flag) break;
            
            time++;
        }
    }
}