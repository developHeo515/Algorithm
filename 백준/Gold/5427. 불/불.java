//BOJ5427 불, 골4
//BFS 문제
import java.io.*;
import java.util.*;

public class Main {
	static class fire {
		int x;
		int y;
		public fire(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int w, h;
	static char[][] map;
	static Queue<fire> fq;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy	= {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			fq = new LinkedList<>();
			
			int x = 0; 
			int y = 0; //상근이 위치
			
			for(int i = 0; i < h; i++) {
				String temp = br.readLine();
				for(int j = 0; j < w; j++) {
					char c = temp.charAt(j);
					map[i][j] = c;
					if(c == '*') {
						fq.add(new fire(i, j));
					}else if(c == '@') {
						x = i;
						y = j;
					}
				}
			}
			
//			for(int i = 0; i < h; i++) {
//				for(int j = 0; j < w; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			int result = bfs(x, y);
			if(result == -1) {
				bw.write("IMPOSSIBLE" + "\n");
			}else {
				bw.write(result + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt++;
			
			int fireSize = fq.size();
			while(fireSize-- != 0) {
				fire fcur = fq.poll();
				int fx = fcur.x;
				int fy = fcur.y;
				
				for(int dic = 0; dic < 4; dic++) {
					int nfx = fx + dx[dic];
					int nfy = fy + dy[dic];
					if(nfx < 0 || nfy < 0 || nfx >= h || nfy >= w) continue;
					if(map[nfx][nfy] == '.' || map[nfx][nfy] == '@') {
						fq.add(new fire(nfx, nfy));
						map[nfx][nfy] = '*';
					}
				}
			}
			
			int qsize = q.size();
			while(qsize-- != 0) {
				int[] cur = q.poll();
				int cx = cur[0];
				int cy = cur[1];
				
				for(int dic = 0; dic < 4; dic++) {
					int nx = cx + dx[dic];
					int ny = cy + dy[dic];
					if(nx < 0 || ny < 0 || nx >= h || ny >= w) // 탈출 조건
						return cnt;
					if(map[nx][ny] == '.') {
						q.add(new int[] {nx, ny});
						map[nx][ny] = '@';
					}
				}
				
			}
		}
		
		return -1;
	}
}
