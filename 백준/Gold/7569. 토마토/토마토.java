//BOJ7569 토마토, 골드5
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, H, ans;
	static int[][][] toma;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = 987654321;
		
		toma = new int[H+1][N+1][M+1];
		
		int cnt = 0;
		int zeroCnt = 0;
		int emptyCnt = 0;
		for(int k = 1; k <= H; k++) {
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= M; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n == 1) {
						q.add(new int[] {k, i, j});
						cnt++;
					}else if(n == 0) {
						zeroCnt++;
					}else if(n == -1) {
						emptyCnt++;
					}
					toma[k][i][j] = n;
				}
			}
		}
		
//		for(int k = 1; k <= H; k++) {
//			for(int i = 1; i <= N; i++) {
//				for(int j = 1; j <= M; j++) {
//					System.out.print(toma[k][i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("윗층");
//		}
		
		if(zeroCnt != 0) { //안 익은 토마토가 있어야 함수 실행
//			System.out.println("함수 실행");
			bfs();
		}
			
		
		if(cnt == N*M*H - emptyCnt) {
			ans = 0;
		}
		for (int k = 1; k <= H; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(toma[k][i][j] == 0) {
						ans = -1;
					}
				}
			}
		}
		
		bw.write(ans+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void bfs() {
		int qsize;
		int day = -1; //처음에 토마토 넣은 초기값도 1일 더해지므로 -1로 시작해야함
		
		while(!q.isEmpty()) {
			qsize = q.size();
			day++;
//			System.out.println(qsize + " 날짜 : " + day);
			while(qsize != 0) {
				qsize--;
				int[] cur = q.poll();
				int ch = cur[0];
				int cx = cur[1];
				int cy = cur[2];
				
				int upH = ch + 1;
				int downH = ch - 1;
				if(upH <= H) {
					if(toma[upH][cx][cy] == 0) {
						toma[upH][cx][cy] = 1;
						q.add(new int[] {upH, cx, cy});
					}
				}
				if(downH >= 1) {
					if(toma[downH][cx][cy] == 0) {
						toma[downH][cx][cy] = 1;
						q.add(new int[] {downH, cx, cy});
					}
				}
				
				for(int dic = 0; dic < 4; dic++) {
					int nx = cx + dx[dic];
					int ny = cy + dy[dic];
					
					if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
					if(toma[ch][nx][ny] == 0) {
						toma[ch][nx][ny] = 1;
						q.add(new int[] {ch, nx, ny});
					}
				}
				
			}
		}
		ans = day;
	}
}
