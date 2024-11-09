
//BOJ2146 다리 만들기, 골드3
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] islandNum, map;
	static int N, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		islandNum = new int[N][N];
		ans = 987654321;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			}
		}

		// 섬 영역 구분짓기
		int islandCnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// islandNum[i][j] == 0 이게 방문처리 역할, 섬 영역이 정해지지 않았다는 뜻
				if (map[i][j] == 1 && islandNum[i][j] == 0) {
					connection(islandCnt, i, j);
					islandCnt++;
				}
			}
		}

//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(islandNum[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 다리 연결 시도
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
//					System.out.println(i+ " " + j);
					bfs(i, j, islandNum[i][j]);
				}
			}
		}
//		bfs(0, 2, islandNum[0][2]);
//		bfs(4, 3, islandNum[4][3]);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	// 다리 연결하기
	static void bfs(int initX, int initY, int LandNum) {
//		System.out.println("tlwkr : " + initX + " " + initY);
		// 임시 배열 생성
		int[][] temp = new int[N][N];
		int[][] tempLandNum = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[i][j];
				tempLandNum[i][j] = islandNum[i][j];
			}
		}

		int distance = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { initX, initY, distance });

		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			int dist = q.peek()[2];
			q.poll();
			
//			System.out.println(cx + " " + cy);

			for (int dic = 0; dic < 4; dic++) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];

				// 최소 거리보다 길어지거나 같으면 패스
				if (ans <= dist)
					continue;
				// 범위 벗어나면 패스
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				// 다리 연결할 곳이 섬이긴하지만 같은 섬 영역이면 패스
				if (temp[nx][ny] == 1 && LandNum == tempLandNum[nx][ny])
					continue;
				// 다른 섬 도착
				if (temp[nx][ny] == 1 && LandNum != tempLandNum[nx][ny]) {
//					System.out.println(dist + " " + initX + " " + initY);
					ans = Math.min(ans, dist);
				}
				q.add(new int[] { nx, ny, dist + 1 });
				temp[nx][ny] = 1;
				tempLandNum[nx][ny] = LandNum;

			}
		}

	}

	// 섬 영역 구분 짓기
	static void connection(int islandCnt, int initX, int initY) {
		// bfs 통해 하나의 섬 영역을 정해준다.
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { initX, initY });
		islandNum[initX][initY] = islandCnt;

		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();

			for (int dic = 0; dic < 4; dic++) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue; // 범위 밖일때
				if (islandNum[nx][ny] != 0)
					continue; // 이미 섬 영역에 포함됐을 때
				if (map[nx][ny] == 0)
					continue; // 바다일때
				q.add(new int[] { nx, ny });
				islandNum[nx][ny] = islandCnt;
			}
		}
	}
}
