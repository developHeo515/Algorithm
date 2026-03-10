import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int p;
        int dist;
        public Point(int p, int dist){
            this.p = p;
            this.dist = dist;
        }
    }

    static int N;
    static int M;
    static int K;
    static int X;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }
//        System.out.println(graph);

        visit = new boolean[N+1];
        bfs();
        Collections.sort(ans);
//        System.out.println(ans);

        if(ans.isEmpty()){
            bw.write(-1 + "\n");
        }
        else {
            for(int n : ans){
                bw.write(n + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(X, 0));
        visit[X] = true;

        while(!q.isEmpty()){
            Point c = q.poll();
            int cur = c.p;
            int dist = c.dist;

            if(dist == K){
                ans.add(cur);
                continue; //최단거리를 찾았으니 여기서 더 멀어지는 곳을 갈 필요없다.
            }

            for(int next : graph.get(cur)){
                if(!visit[next]){
                    visit[next] = true;
                    q.offer(new Point(next, dist + 1));
                }
            }
        }

    }
}