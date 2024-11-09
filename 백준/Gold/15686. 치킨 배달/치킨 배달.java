//BOJ15686 치킨 배달, 골드5
//백트래킹(2차원 배열 조합 사용) + BFS 문제
//기본기를 연습하기 좋은 문제임
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] chicken;
	static int ans = 987654321;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][N + 1];
		chicken = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					map[i][j] = n;
				} else if (n == 2) {
					chicken[i][j] = n;
				}
			}
		}

//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		backtracking(0, 0, map);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static void backtracking(int depth, int start, int[][] map) {
		if (depth == M) {
//			System.out.println("다보여라");
//			// 각 집에서 치킨 거리 확인
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					if (map[i][j] == 2) {
//						System.out.println(i + " " + j);
//					}
//				}
//			}
//			System.out.println();
			
			//BFS 
			// 각 집에서 치킨 거리 확인
			int total = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 1) {
//						total += bfs(map, i, j);
//						System.out.println(i + " " + j);
						total += bfs(map, i, j);
					}
				}
			}
			
			ans = Math.min(ans, total);
			return;
		}

		for (int i = start; i < N * N; i++) {
			int x = (i/N) + 1;
			int y = (i%N) + 1;
//			System.out.println("실험 : "+x + " " + y);
			// map[i][j] != 2 이게 visited 방문처리 역할이다.
			if (chicken[x][y] == 2 && map[x][y] != 2) {
//				System.out.println("실험 "+i + " " + j);
				map[x][y] = 2;
				backtracking(depth + 1, i+1, map);
				map[x][y] = 0;
				
			}

		}
	}
	
	static int bfs(int[][] map, int x, int y) {
		int distance = 0;
		boolean[][] visited = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y, distance});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			int dist = q.peek()[2];
			q.poll();
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];
				if(nx > 0 && ny > 0 && nx <= N && ny <= N && !visited[nx][ny]) {
					if(map[nx][ny] == 2) {
						return dist + 1;
					}
					else {
						visited[nx][ny]	= true;
						q.add(new int[] {nx, ny, dist+1});
					}
				}
			}
		}
		
		return -1;
	}
}
