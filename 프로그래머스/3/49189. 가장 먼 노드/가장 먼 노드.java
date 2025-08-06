import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
//    static int[] dist;
    static int res;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        visit = new boolean[n+1];
//        dist = new int[n+1];
        res = 0;

        for(int[] e : edge){
            int from = e[0];
            int to = e[1];
            graph[from].add(to);
            graph[to].add(from);
        }
//        System.out.println(Arrays.toString(graph));

        bfs(1);
        answer = res;
        return answer;
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;
//        dist[v] = 1;

        while(!q.isEmpty()){
            int qsize = q.size();
            res = qsize;
            // System.out.println("그래프 탐색 : "+ " " +res);

            while(qsize != 0){
                qsize--;
                int cur = q.poll();

                for(int next : graph[cur]){
                    if(visit[next]) continue;
                    visit[next] = true;
                    q.add(next);
                }
            }

        }
    }
}