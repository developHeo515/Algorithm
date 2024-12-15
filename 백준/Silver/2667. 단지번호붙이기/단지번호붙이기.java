//BOJ2667 단지번호붙이기, 실버1
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] mega;
	static boolean[][] visit;
	static int dangi;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		mega = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0; j < N; j++) {
				mega[i][j] = temp.charAt(j)-'0';
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(mega[i][j] + "");
//			}
//			System.out.println();
//		}
		dangi = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j] && mega[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(dangi); 
		Collections.sort(list);
		for(int num : list) {
			System.out.println(num);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y] = true;
		q.add(new int[] {x, y});
		int house = 0;
		dangi++; //단지 수 추가
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			house++; //단지내 집의 수
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(visit[nx][ny]) continue;
				if(mega[nx][ny] == 1) {
					q.add(new int[] {nx, ny});
					visit[nx][ny] = true;
				}
			}
		}
		list.add(house);
	}
}
