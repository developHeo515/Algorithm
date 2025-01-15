//BOJ16946 벽 부수고 이동하기4, 골2
//bfs의 중복검사를 제거하기 위해 분리집합으로 묶고
//HashMap과 HashSet을 사용하는 예제
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, visit;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static HashMap<Integer, Integer> hm = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		visit = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String temp = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = temp.charAt(j-1) - '0';
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// 0인 애들 분리집합 시키기
		int idx = 1;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(visit[i][j] == 0 && map[i][j] == 0) {
					hm.put(idx, bfs(i, j, idx));
					idx++;
				}
			}
		}

//		for(int i = 1; i <= hm.size(); i++) {
//			System.out.println(hm.get(i));
//		}
		
//		for(int i = 1; i <= N; i++) {
//		for(int j = 1; j <= M; j++) {
//			System.out.print(visit[i][j] + " ");
//		}
//		System.out.println();
//	}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				int num = 1;
				if(map[i][j] == 1) {
					HashSet<Integer> hs = new HashSet<>();
					for(int dic = 0; dic < 4; dic++) {
						int nx = i + dx[dic];
						int ny = j + dy[dic];
						if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
						if(visit[nx][ny] != 0) {
							hs.add(visit[nx][ny]);
						}
					}
					
					for(int cur : hs) {
						num += hm.get(cur);
					}
					bw.write(num % 10 + "");
				}
				else {
					bw.write(0 + "");
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs(int x, int y, int idx) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = idx;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
//			System.out.println(cx + " " + cy);
			
			cnt++; //이동할 수 있는 공간으로 추가
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];
				if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
				if(visit[nx][ny] == 0 && map[nx][ny] == 0) {
					visit[nx][ny] = idx;
					q.add(new int[] {nx, ny});
				}
			}
		}
		
//		System.out.println(cnt);
		return cnt;
	}
}
