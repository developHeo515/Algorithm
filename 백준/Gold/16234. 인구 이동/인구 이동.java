//BOJ16234 인구 이동, 골4
// BFS, 구현 문제
// 2차원 배열로 기록하는 것이 아닌 ArrayList 를 사용하여 시간초과를 막았어야 했다..
import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, L, R;
	static int[][] board;
	static boolean[][] visit;
	static ArrayList<Point> move = new ArrayList<>();
	static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상
	static int[] dy = {1, 0, -1, 0};
	static boolean move_status = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		while(true) {
			visit = new boolean[N][N]; // 하루 연합 처리
			move_status = false;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						bfs(i, j);	
					}
				}
			}	
				
			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(board[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("한바퀴끝");
//			System.out.println();
			
			if(!move_status) {
				break;
			}
			
			res++;
		}
		
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visit[x][y] = true;
		move.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
//			System.out.println("start : " + cx + " " + cy);
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(visit[nx][ny]) continue;
				
				int move_diff = Math.abs(board[nx][ny] - board[cx][cy]);
//				System.out.println(nx + " " + ny + " - " + move_diff);
				if(L <= move_diff && move_diff <= R) {
					move_status = true;
					visit[nx][ny] = true; //방문처리
					
					move.add(new Point(nx, ny));
//					move[cx][cy] = true;
//					move[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		
//		if(!move_status) {
//			return;
//		}
		
		int sum = 0;
//		int person_cnt = move.size();
		for(int i = 0; i < move.size(); i++) {
			Point p = move.get(i);
			sum += board[p.x][p.y];
		}
		
//		System.out.println(sum + " - " + move.size());
		
		
//		System.out.println(sum / move.size() + " ddd");
		
		for(int i = 0; i < move.size(); i++) {
			Point p = move.get(i);
			board[p.x][p.y] = sum / move.size();
		}
		
		move.removeAll(move);
		
	}
}
