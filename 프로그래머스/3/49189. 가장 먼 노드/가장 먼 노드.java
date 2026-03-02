import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] e : edge){
            // 양방향
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        int[] dist = new int[n+1];
//        System.out.println(list);
        bfs(new boolean[n+1], list, dist);

        int max = 0;
        for(int i = 1; i < dist.length; i++){
            max = Math.max(max, dist[i]);
        }

        for(int i = 1; i < dist.length; i++){
            if(max == dist[i]){
                answer++;
            }
        }

        return answer;
    }
    static void bfs(boolean[] visit, List<List<Integer>> list, int[] dist){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, 0});
        visit[1] = true;
        dist[1] = 0;

        while(!q.isEmpty()){
            int[] c = q.poll();
            int cur = c[0];
            int distance = c[1];

            for(int next : list.get(cur)){
                if(!visit[next]){
                    visit[next] = true;
                    dist[next] = distance + 1;
                    q.offer(new int[] {next, distance + 1});
                }
            }
        }
    }
}