//BOJ2636 치즈, 골드4
//겉에 공기일때 -> 공기에 마찰되어 있을 때, 4방 탐색
//
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, total;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag = true;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상	
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1)
					total++;  //치즈갯수
				map[i][j] = num;
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int time = 0; // 시간
		int lastCheese = 0; //다 사라지기 전 마지막 치즈 갯수
		while(flag) {  // 치즈가 남아있는 한 계속 반복
			lastCheese = total;
			total = 0; //치즈 갯수 0으로 초기화
			BFS();
			time++; //한 시간 증가
		}
		
		bw.write(time + "\n");
		bw.write(lastCheese+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		visit = new boolean[N+1][M+1];
		q.add(new int[] {1, 1});
		visit[1][1] = true;
		
		if(N == 1 && M == 1) {
			flag = false;
			if(map[N][M] == 1) {
				total = 1;
				return;
			}else {
				total = 0;
				return;
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			
			for(int dic = 0; dic < 4; dic++) {
				int nextX = curX + dx[dic];
				int nextY = curY + dy[dic];
				
				if(nextX < 1 || nextY < 1 || nextX > N || nextY > M) continue;
				//공기만났을때 계속 확산
				if(!visit[nextX][nextY] && map[nextX][nextY] == 0) {
					visit[nextX][nextY] = true;
					q.add(new int[] {nextX, nextY});
				}
				//치즈 겉면 만났을때
				else if(!visit[nextX][nextY] && map[nextX][nextY] == 1) { 
					visit[nextX][nextY] = true;
					map[nextX][nextY] = 0;
				}
				
			}
		}
		
		//한 시간 뒤 남은 치즈 갯수 구하기
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 1) {
					total++;
				}
			}
		}

		// 치즈 다 사라졌으니 while문 탈출
		if(total == 0) {
			flag = false;
		}
	}
}
