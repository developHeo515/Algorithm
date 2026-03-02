import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }

        int cnt = 0;
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                cnt++;
                bfs(i);
            }
        }
        return answer = cnt;
    }
    static void bfs(int n){
        Queue<Integer> q = new ArrayDeque<>();
        visit[n] = true;
        q.add(n);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph.get(cur)){
                if(!visit[next]){
                    visit[next] = true;
                    q.add(next);
                }
            }
        }
    }
}