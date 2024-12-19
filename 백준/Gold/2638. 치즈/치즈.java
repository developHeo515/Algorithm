//BOJ2638 치즈, 골3
//BFS문제
//1. 외부 공기와 내부 공기를 구분한다.
//2. BFS돌며 2변 이상이 실내온도와 접촉한 치즈를 찾아서 제거(제거시 내부 공기로 해버리면될듯 - 옆에 치즈가 실내온도로 접촉한 카운트 안 오르게)
//3. 전체 돌며 치즈 남아있는지 검사
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] cheese;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0}; 
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//1. 외부 공기와 내부 공기를 구분한다.
		air(1, 1);
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				bw.write(cheese[i][j] + " ");
//			}
//			bw.write("\n");
//		}
		
		//2. BFS돌며 2변 이상이 실내온도와 접촉한 치즈를 찾아서 제거(제거시 내부 공기로 
		//해버리면될듯 - 옆에 치즈가 실내온도로 접촉한 카운트 안 오르게)
		int hour = 0;
		flag = true;
		while(flag) {
			visit = new boolean[N+1][M+1];
			hour++;
			
			//치즈 검사 시작
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(cheese[i][j] == 1 && !visit[i][j]) {
						BFS(i, j);
					}
				}
			}
			
			//한시간 동안 치즈 검사 마쳤으니 2로 녹여버린 치즈들을 실외공기로 바꾼다.
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(cheese[i][j] == 2) {
//						cheese[i][j] = -1;  //이거는 치즈 녹인 공간만 실외공기로 바꿔줘서 반례생김
						//치즈 녹이고 오픈된 공간은 전부 실외공기로 바꿔야한다.
						air(i, j);
					}
				}
			}
			
			//3. 전체 돌며 치즈 남아있는지 검사
			int cheeseCnt = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(cheese[i][j] == 1) { 
						cheeseCnt++;
					}
				}
			}
			
			//진행과정 디버깅
//			for(int i = 1; i <= N; i++) {
//				for(int j = 1; j <= M; j++) {
//					if(cheese[i][j] == -1) { 
//						bw.write(0 + " ");
//					}
//					else if(cheese[i][j] == 0) {
//						bw.write(5+ " ");
//					}
//					else {
//						bw.write(cheese[i][j] + " ");
//					}
//				}
//				bw.write("\n");
//			}
//			bw.write("\n");
			
			if(cheeseCnt == 0) // 치즈가 하나도 없다면 종료
				flag = false;
		}
		
		bw.write(hour + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	//2. BFS돌며 2변 이상이 실내온도와 접촉한 치즈를 찾아서 제거(제거시 내부 공기로 
	//해버리면될듯 - 옆에 치즈가 실내온도로 접촉한 카운트 안 오르게)
	static void BFS(int initX, int initY) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {initX, initY});
		visit[initX][initY] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			int airCnt = 0;
			for(int dic = 0; dic < 4; dic++) {
				int nx = x + dx[dic];
				int ny = y + dy[dic];
				if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
				if(cheese[nx][ny] == -1) //실외공기와 접촉했을떄
					airCnt++;
				else if(cheese[nx][ny] == 1 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
			if(airCnt >= 2) {
				//치즈를 녹여없애는데 -1로 바꾸면 실외공기가 되어서 옆에 치즈에 영향을 준다.
				//그렇기 때문에 임시로 2로해서 영향을 안주게함
				cheese[x][y] = 2; 
			}
		}
	}
	
	//1. 외부 공기와 내부 공기를 구분한다.
	// 외부 공기는 -1, 내부 공기는 0
	static void air(int initX, int initY) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {initX, initY});
		cheese[initX][initY] = -1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = x + dx[dic];
				int ny = y + dy[dic];
				if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
				if(cheese[nx][ny] == 0) {
					q.add(new int[] {nx, ny});
					cheese[nx][ny] = -1;
				}
			}
		}
	}
}
