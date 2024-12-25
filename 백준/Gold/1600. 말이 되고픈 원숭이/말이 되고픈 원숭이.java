//BOJ1600 말이 되고픈 원숭이, 골3
//bfs 문제 + 3차원 배열
//일반적인 4방탐색 + 나이트의 이동 8방향을 전부 큐에 넣어주면서 진행하면 되는 문제 
import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		int x;
		int y;
		int cnt;
		int k;
		public Pos(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
	static int K, W, H;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static int[] hx = {-2, -1, 1, 2, 1, 2, -1, -2}; // 나이트 이동방식 8방향
	static int[] hy = {1, 2, 2, 1, -2, -1, -2, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][W+1];
		for(int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 1; i <= H; i++) {
//			for(int j = 1; j <= W; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int result = bfs();
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][][] visit = new boolean[K+1][H+1][W+1];
		q.add(new Pos(1, 1, 0, 0)); //x, y, cnt, k의 수
		visit[0][1][1] = true; //초기값, Pos에 cnt값 있어서 int 안하고 boolean 해도 된다.
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			int curK = cur.k;
			
//			System.out.println(x + " " + y + " " + cnt + " " + curK);
			
			if(x == H && y == W) return cnt;
			
			//4방 탐색
			for(int dic = 0; dic < 4; dic++	) {
				int nx = x + dx[dic];
				int ny = y + dy[dic];
				if(nx < 1 || ny < 1 || nx > H || ny > W) continue;
				if(map[nx][ny] == 0 && !visit[curK][nx][ny]) {
					q.add(new Pos(nx, ny, cnt+1, curK));
					visit[curK][nx][ny] = true;
				}
			}
				
			//나이트 8방 탐색
			if(curK < K) {
				for(int dic = 0; dic < 8; dic++) {
					int nx = x + hx[dic];
					int ny = y + hy[dic];
					if(nx < 1 || ny < 1 || nx > H || ny > W) continue;
					if(map[nx][ny] == 0 && !visit[curK+1][nx][ny]) {
						q.add(new Pos(nx, ny, cnt+1, curK+1));
						visit[curK+1][nx][ny] = true;
					}
				}
			}
		}
		
		return -1;
	}
}



