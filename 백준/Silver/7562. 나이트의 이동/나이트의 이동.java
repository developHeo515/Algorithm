import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            int l = Integer.parseInt(br.readLine());
            int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; //1시 방향이 스타트
            int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
            int[] present = new int[2];
            int[] goal = new int[2];
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            present[0] = Integer.parseInt(st.nextToken());
            present[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());

            //bfs 실행
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {present[0], present[1], 0});
            boolean[][] visit = new boolean[l][l];
            visit[present[0]][present[1]] = true;

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];
                int ct = cur[2];

                if(cx == goal[0] && cy == goal[1]){
                    cnt = ct;
                    break;
                }

                for(int dir = 0; dir < 8; dir++){
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                    if(!visit[nx][ny]) {
                        q.offer(new int[] {nx, ny, ct+1});
                        visit[nx][ny] = true;
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}