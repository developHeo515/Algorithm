import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int w; //y
    static int h; //x
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // 우, 우하, 하, 좌하, 좌, 좌상, 상, 우상
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while(w != 0 || h != 0){
            map = new int[h][w];
            visit = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    int n = Integer.parseInt(st.nextToken());
                    map[i][j] = n;
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] == 1 && !visit[i][j]){
                        ans++;
                        bfs(i, j);
                    }
                }
            }
            bw.write(ans + "\n");

            ans = 0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int dir = 0; dir < 8; dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if(map[nx][ny] == 1 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
}