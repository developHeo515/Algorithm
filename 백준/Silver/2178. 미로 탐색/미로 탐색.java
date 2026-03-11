import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                char ch = str.charAt(j);
                map[i][j] = ch - '0';
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
        }

        bfs();

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1));
        visit[0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;

            if(x == N-1 && y == M-1){
                ans = dist;
                break;
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(!visit[nx][ny] && map[nx][ny] == 1){
                    q.add(new Node(nx, ny, dist+1));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}