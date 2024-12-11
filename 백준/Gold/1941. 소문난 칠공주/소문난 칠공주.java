// BOJ1941 소문난 칠공주, 골3
// 백트래킹, BFS
import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static boolean[] visited;
	static int[] selected;
	static int res;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new char[5][5];
		selected = new int[7];
		
		for(int i = 0; i < 5; i++) {
			String temp = br.readLine();
			for(int j = 0; j < 5; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j < 5; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		res = 0;
		back(0, 0, 0);
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
 	}
	static void back(int depth, int Ynum, int start) {
		if(Ynum >= 4) return;
		
		if(depth == 7) {
			visited = new boolean[7];
			BFS();
			return;
		}
		
		for(int i = start; i < 25; i++) {
			selected[depth] = i;
			if(map[i/5][i%5] == 'Y') {
				back(depth + 1, Ynum + 1, i+1);
			}
			else {
				back(depth + 1, Ynum, i+1);
			}
		}
		
	}
	static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {selected[0]/5, selected[0]%5});
		visited[0] = true;
		int cnt = 1; //연결 수
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = x + dx[dic];
				int ny = y + dy[dic];
				int nidx = nx * 5 + ny; // 0~24 idx
				
				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
				for(int i = 0; i < 7; i++) {
					if(!visited[i] && selected[i] == nidx) {
						q.add(new int[] {nx, ny});
						visited[i] = true;
						cnt++;
					}
				}
			}
		}
		if(cnt == 7) res++;
	}
}
