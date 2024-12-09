import java.io.*;
import java.util.*;

public class Main {
	static int[][] toma;
	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<int[]> q = new LinkedList<>();
	static int M, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		toma = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					q.add(new int[] { i, j });
				}
				toma[i][j] = num;
			}
		}
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(toma[i][j] + " ");
//			}
//			System.out.println();
//		}

		int result = bfs();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(toma[i][j] == 0) {
					result = -1;
				}
//				System.out.print(toma[i][j] + " ");
			}
//			System.out.println();
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {
		int cnt = 0;
		int qsize = 0;
		
		while (!q.isEmpty()) {
			qsize = q.size();
			cnt++;
			while(qsize != 0) {
				qsize--;
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				
				for(int dic = 0; dic < 4; dic++) {
					int nx = x + dx[dic];
					int ny = y + dy[dic];
					if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
					if(toma[nx][ny] == -1) continue;
					if(toma[nx][ny] == 0) {
						q.add(new int[] {nx, ny});
						toma[nx][ny] = cnt;
					}
				}
			}
		}
		cnt--;
		return cnt;
	}
}
