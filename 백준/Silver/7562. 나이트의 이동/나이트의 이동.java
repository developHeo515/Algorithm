//BOJ7562 나이트의 이동, 실1
//BFS 문제
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; // 나이트 8방향
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1}; //
	static int L;
	static int[][] chess;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			L = Integer.parseInt(br.readLine());
			chess = new int[L][L];
			
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
//			System.out.println(startX + " " +  startY + " " + endX + " " + endY);
			int res = BFS(startX, startY, endX, endY);
			bw.write(res + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static int BFS(int startX, int startY, int endX, int endY) {
		int cnt = 0 ;
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {startX, startY});
		boolean[][] visit = new boolean[L][L];
		visit[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int qsize = q.size();
			
			while(qsize-- != 0) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				
				if(x == endX && y == endY) {
					return cnt;
				}
				
				for(int dic = 0; dic < 8; dic++) {
					int nx = x + dx[dic];
					int ny = y + dy[dic];
					if(nx < 0 || ny < 0 || nx >= L || ny >= L) continue;
					if(visit[nx][ny]) continue;
					
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
			
			cnt++;
		}
		return -1;
	}
}
