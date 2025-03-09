//BOJ15683 감시, 골3
import java.io.*;
import java.util.*;

public class Main {
	static class CCTV{
		int x;
		int y;
		int num;
		
		public CCTV(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	static int N, M;
	static int[][] arr;
	static int[][] copyMap;
	static int[] dx = {-1, 0, 1, 0}; //상 우 하 좌
	static int[] dy	= {0, 1, 0, -1};
	static int[] output;
	static ArrayList<CCTV> cctvList;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		cctvList = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				int area = Integer.parseInt(st.nextToken());
				arr[i][j] = area;
				if(area != 0 && area != 6) {
					cctvList.add(new CCTV(i, j, area));
				}
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		output = new int[cctvList.size()];
		permutation(0, cctvList.size());
		
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void permutation(int depth, int r) {
		if(depth == r) {
			copyMap = new int[N+1][M+1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					copyMap[i][j] = arr[i][j];
				}
			}
			
			for(int i = 0; i < cctvList.size(); i++) {
				direction(cctvList.get(i), output[i]);
			}
			
			// 사각 지대 구하기
			BlindSpot();
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			output[depth] = i;
			permutation(depth+1, r);
		}
	}
	
	// 각 cctv 번호와 순열로 뽑혀진 방향에 맞게 감시 
	static void direction(CCTV cctv, int d) {
		int cctvNum = cctv.num;

		if(cctvNum == 1) {
			if(d == 0) watch(cctv, 0); // 상 
			else if(d == 1) watch(cctv, 1); // 우 
			else if(d == 2) watch(cctv, 2); // 하  
			else if(d == 3) watch(cctv, 3); // 좌 
		} else if(cctvNum == 2) {
			if(d == 0 || d == 2) {
				watch(cctv, 0); watch(cctv, 2); // 상하 
			} else {
				watch(cctv, 1); watch(cctv, 3); // 좌우 
			}
		} else if(cctvNum == 3) {
			if(d == 0) {
				watch(cctv, 0); // 상우 
				watch(cctv, 1);
			} else if(d == 1) { 
				watch(cctv, 1); // 우하 
				watch(cctv, 2);
			} else if(d == 2) { 
				watch(cctv, 2); // 하좌 
				watch(cctv, 3);
			} else if(d == 3) { 
				watch(cctv, 0); // 좌상 
				watch(cctv, 3);
			}
		} else if(cctvNum == 4) {
			if(d == 0) {
				watch(cctv, 0); // 좌상우 
				watch(cctv, 1);
				watch(cctv, 3);
			} else if(d == 1) {
				watch(cctv, 0); // 상우하 
				watch(cctv, 1);
				watch(cctv, 2);
			} else if(d == 2) {
				watch(cctv, 1); // 좌하우 
				watch(cctv, 2);
				watch(cctv, 3);
			} else if(d == 3) {
				watch(cctv, 0); // 상좌하 
				watch(cctv, 2);
				watch(cctv, 3);
			}
		} else if(cctvNum == 5) { // 상우하좌
			watch(cctv, 0);
			watch(cctv, 1);
			watch(cctv, 2);
			watch(cctv, 3);
		}
	}
	
	static void watch(CCTV cctv, int d) {
		Queue<CCTV> q = new LinkedList<>();
		boolean[][] visited = new boolean[N+1][M+1];
		
		q.add(cctv);
		visited[cctv.x][cctv.y] = true;
		
		while(!q.isEmpty()) {
			int nx = q.peek().x + dx[d];
			int ny = q.poll().y + dy[d];
//			System.out.println(nx + " " + ny);
			
			if(nx < 1 || ny < 1 || nx > N || ny > M || copyMap[nx][ny] == 6) {
				break;
			}
			
			if(copyMap[nx][ny] == 0) {
				copyMap[nx][ny] = -1; //빈칸이라 감시가능한걸로 -1 넣음
				q.add(new CCTV(nx, ny, cctv.num));
			} else {
				q.add(new CCTV(nx, ny, cctv.num));
			}
		}
	}
	
	
	static void BlindSpot() {
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		ans = Math.min(ans, cnt);
	}
}



