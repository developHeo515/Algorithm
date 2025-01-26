//BOJ4179 불!, 골3
import java.io.*;
import java.util.*;

public class Main {
	static class Info{
		int x;
		int y;
		
		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int R, C;
	static char[][] map;
	static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상
	static int[] dy = {1, 0, -1, 0};
	static boolean flag = true;
	static Queue<Info> fq = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		int Jx = 0;
		int Jy = 0; 
		int Fx = 0;
		int Fy = 0;
		
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				char ch = tmp.charAt(j);
				if(ch == 'J') {
					Jx = i;
					Jy = j;
				}
				else if(ch == 'F') {
//					Fx = i;
//					Fy = j;
					fq.add(new Info(i, j));
				}
				map[i][j] = ch;
			}
		}
		
//		System.out.println(Jx + " " + Jy + " " + Fx + " " + Fy);
		
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		int res = bfs(Jx, Jy);
		
		if(flag) {
			bw.write(res + "\n");
		}
		else {
			bw.write("IMPOSSIBLE" + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int bfs(int Jx, int Jy) {
		boolean[][] visit = new boolean[R][C];
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(Jx, Jy));
//		fq.add(new Info(Fx, Fy));
//		visit[Jx][Jy] = true;
		int time = 0; //탈출 시간
		
		while(!q.isEmpty()) {
			int qsize = q.size();
			int fqsize = fq.size();
			time++;
			while(qsize-- != 0) {
				Info cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				
//				System.out.println(x + " " + y + " " + map[x][y]);
				if(map[x][y] == 'F') continue;
				
				for(int dic = 0; dic < 4; dic++) {
					int nx = x + dx[dic];
					int ny = y + dy[dic];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
						return time;
					}
					if(map[nx][ny] == '.' && !visit[nx][ny]) {
//						System.out.println(nx + " " + ny);
						q.add(new Info(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			
			while(fqsize-- != 0) {
				Info cur = fq.poll();
				int x = cur.x;
				int y = cur.y;
				
				for(int dic = 0; dic < 4; dic++) {
					int nx = x + dx[dic];
					int ny = y + dy[dic];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
						continue;
					}
					if(map[nx][ny] == '.' || map[nx][ny] == 'J') {
						map[nx][ny] = 'F';
						fq.add(new Info(nx, ny));
					}
				}
			}
		}
		
		flag = false;
		return -1;
	}
}
