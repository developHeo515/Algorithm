import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<Integer>> graph;
    static int cnt;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(i, new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        cnt = 0;
        visit = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                cnt++;
                func(i);
//                System.out.println();
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void func(int v){
//        System.out.print(v + " ");
        visit[v] = true;

        for(int next : graph.get(v)){
            if(!visit[next]){
                func(next);
            }
        }
    }
}