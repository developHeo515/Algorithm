import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {0, 1}; // 우 하
        int[] dy = {1, 0};
        q.offer(new int[] {1, 1});
        boolean flag = false;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if(cx == N && cy == N) {
                flag = true;
                break;
            }

            for(int dir = 0; dir < 2; dir++){
                int count = arr[cx][cy];
                int nx = cx;
                int ny = cy;

                if(count == 0) continue;

                for(int k = 0; k < count; k++){
                    nx += dx[dir];
                    ny += dy[dir];
                }

                if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
                q.offer(new int[] {nx, ny});

            }
        }

        if(flag){
            bw.write("HaruHaru" + "\n");
        }
        else {
            bw.write("Hing" + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}