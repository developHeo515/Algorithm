//SWEA10966 물놀이를 가자, D4
import java.io.*;
import java.util.*;

public class Solution {
	static class Water {
		int x, y;

		public Water(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static char[][] map;
	static int[][] dist;
//	static ArrayList<Water> WQ;
	static Queue<Water> WQ = new LinkedList<>();
	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 };
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			dist = new int[N][M];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < M; j++) {
					char ch = temp.charAt(j);
					if (ch == 'W') {
						WQ.add(new Water(i, j));
					}
					map[i][j] = ch;
				}
			}

			while(!WQ.isEmpty()) {
				Water test = WQ.poll();
				int curX = test.x;
				int curY = test.y;
				
				for (int dic = 0; dic < 4; dic++) {
					int nextX = test.x + dx[dic];
					int nextY = test.y + dy[dic];
					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

					if(map[nextX][nextY] == 'L') {
						if (dist[nextX][nextY] > dist[curX][curY] + 1 || dist[nextX][nextY] == 0) {
							dist[nextX][nextY] = dist[curX][curY] + 1;
							WQ.add(new Water(nextX, nextY));
						}
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(dist[i][j] + " ");
//				}
//				System.out.println();
//			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans += dist[i][j];
				}
			}
			bw.write("#" + tc + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
