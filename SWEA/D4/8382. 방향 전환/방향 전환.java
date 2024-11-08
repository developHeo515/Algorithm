//SWEA 8382 방향 전환, D4
//처음에 접근을 잘못했다. 그냥 int[][] map 함수로 다익스트라 느낌으로 풀었는데 테케 50개 중에 45개만 맞음
//pair 클래스를 사용하고 int[][] map 함수를 지우고 pair 클래스 내부에 dist 로 구하기로함
//visit를 3차원으로 하여 가로 세로 방향에 따라 이동하게 했어야했음
// 벽 부수고 이동하기처럼 생각했어야 했는데 이 방향을 생각하지 못한게 아쉬움
import java.io.*;
import java.util.*;

public class Solution {
	static class Pair {
		int r, c, dist, dir;

		public Pair(int r, int c, int dist, int dir) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.dir = dir;
		}
	}

	static int c1, r1, c2, r2;
	static int dr[] = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.valueOf(st.nextToken()) + 100;
			r1 = Integer.valueOf(st.nextToken()) + 100;
			c2 = Integer.valueOf(st.nextToken()) + 100;
			r2 = Integer.valueOf(st.nextToken()) + 100;

			int ans = bfs();
			bw.write("#" + tc + " " + ans + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {
		Queue<Pair> q = new LinkedList<>();
		boolean visit[][][] = new boolean[2][201][201];
		q.add(new Pair(r1, c1, 0, 0));
		q.add(new Pair(r1, c1, 0, 1));

		visit[0][r1][c1] = true; // 현재 방향 세로
		visit[1][r1][c1] = true; // 가로
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (cur.r == r2 && cur.c == c2) {
				return cur.dist;
			}
			for (int i = 0; i < 4; i++) {
				int nextR = 0;
				int nextC = 0;
				int nextDic = 0;
				if (cur.dir % 2 == 0 && i % 2 == 1) { // 현재가 세로방향, 다음은 가로방향
					nextR = cur.r + dr[i];
					nextC = cur.c + dc[i];
					nextDic = 1;
				} else if (cur.dir % 2 == 1 && i % 2 == 0) { // 현재 가로 방향, 다음은 세로방향
					nextR = cur.r + dr[i];
					nextC = cur.c + dc[i];
					nextDic = 0;
				} else {
					continue;
				}
				if(nextR < 0 || nextR > 200 || nextC < 0 || nextC > 200 || visit[nextDic][nextR][nextC]) continue;
				visit[nextDic][nextR][nextC] = true;
				q.add(new Pair(nextR, nextC, cur.dist + 1, nextDic));
			}
		}
		return 0;
	}
}
