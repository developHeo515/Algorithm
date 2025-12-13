import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visit = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        visit[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if(cx == n-1 && cy == m-1){
//                System.out.println(cx + " - " + cy);
                answer = cnt;
                break;
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visit[nx][ny]) continue;
                if(maps[nx][ny] == 1){
                    visit[nx][ny] = true;
                    q.add(new int[] {nx, ny, cnt+1});
                }
            }

        }

        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}