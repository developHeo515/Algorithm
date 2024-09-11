//BOJ14502 연구소 골드4
//순조부에 조합 + BFS를 생각했다. 
//이론은 정답에 가깝게 생각했고 java로 생각한 것을 작성하는 것이 아직은 어렵다.
import java.io.*;
import java.util.*;


public class Main {
	static int maxArea;
	static int N, M;
	static int[][] map;
	static int[] dx	= {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		
//		System.out.println(Arrays.deepToString(copyMap));

//		for(int[] i : map) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(i[j] +" ");
//			}
//			System.out.println();
//		}
		
		maxArea = 0;
		combination(0);
		sb.append(maxArea);
		System.out.println(sb);
	}
	static void combination(int depth) {
		if(depth == 3) {
			bfs();
			return; 
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					combination(depth+1);
					map[i][j] = 0; //visited 를 map에다가 0과 1로 표현했다.
				}
			}
		}
		
	}
	static void bfs() {
		//바이러스 숫자 2를 찾아서 다 큐에 넣고
		//만나는 0은 다 1로 감염시킴
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2)
					q.add(new int[] {i, j});
			}
		}
		
		int[][] copyMap = new int[N][M];
		for(int  i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(copyMap[i][j] +" ");
//			}
//			System.out.println();
//		}
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int curX = arr[0];
			int curY = arr[1];
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = curX + dx[dic];
				int ny = curY + dy[dic];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(copyMap[nx][ny] == 1) continue;
				// copyMap[nx][ny] == 2는 어차피 큐에 사전에 넣어줘서 또 넣어줄 필요없다.
				if(copyMap[nx][ny] == 0) {
					copyMap[nx][ny] = 2;
					q.add(new int[] {nx, ny});
				}
			}
		}
		check(copyMap);
	}
	
	static void check(int[][] copyMap) {
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(copyMap[i][j] +" ");
//			}
//			System.out.println();
//		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		if(maxArea < cnt) {
			maxArea = cnt;
		}
	}
}








