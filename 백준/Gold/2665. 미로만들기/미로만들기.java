//BOJ2665 미로만들기, 골4
//다익스트라 알고리즘
//메모리초과로 애먹음
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] bang;
	static int[][] score;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		bang = new int[N][N];
		score = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < N; j++) {
				bang[i][j] = temp.charAt(j) - '0';
				score[i][j] = INF;
			}
		}
		
		dijkstra();
		
//		for(int i = 0; i < N; i++) {
//		for(int j = 0; j < N; j++) {
//			System.out.print(score[i][j]);
//		}
//		System.out.println();
//	}
		
		bw.write(score[N-1][N-1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void dijkstra() {
		Queue<int[]> pq = new LinkedList<>();
		pq.add(new int[] {0,0,0}); //x, y, cost
		score[0][0] = 0; // 초기값 설정
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int cost = cur[2];
//			System.out.println(x + " " + y);
			
//			if(score[x][y] < cost) continue; //메모리 초과를 피하기 위해 시도
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = x + dx[dic];
				int ny = y + dy[dic];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				

				//다음 score와 비교하기 위해서는 미리 다음 방이 0인지 1인지 구분하고 다음 cost를 업데이트하고 
				//비교해줘야 한다.
//				int newCost = cost + (bang[nx][ny] == 1 ? 0 : 1);
				int newCost = 0;
				if(bang[nx][ny] == 1)
					newCost = cost;
				else 
					newCost = cost + 1;  
				
				if(newCost < score[nx][ny]) {
					score[nx][ny] = newCost;
					pq.add(new int[] {nx, ny, newCost});
				}
				
				//이렇게 하면 메모리 초과 발생
//				if(score[nx][ny] > cost) {
//					if(bang[nx][ny] == 1) {
//						pq.add(new int[] {nx, ny, cost});
//						score[nx][ny] = cost;
//					}
//					else if(bang[nx][ny] == 0) {
//						pq.add(new int[] {nx, ny, cost+1});
//						score[nx][ny] = cost + 1;	
//					}
//				}
			}
			
		}
	}
}
