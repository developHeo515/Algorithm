//SWEA1249 보급로, D4
import java.io.*;
import java.util.*;

public class Solution {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dist;
		
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
		
	}
	static int N, ans;
	static int[][] map, score;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			score = new int[N+1][N+1];
			
			for(int i = 1; i <= N; i++) {
				String temp = br.readLine();
				for(int j = 1; j <= N; j++) {
					char ch = temp.charAt(j-1);
					String num = Character.toString(ch);
					map[i][j] = Integer.parseInt(num);
					score[i][j] = INF;
				}
			}
			

			
			ans = INF;
			ans = func();
			
//			for(int i = 1; i <= N; i++) {
//				for(int j = 1; j <= N; j++) {
//					System.out.print(score[i][j] + " ");
//				}
//				System.out.println();
//			}
		
			bw.write("#" + tc + " " + ans + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int func() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 1, 0));
		score[1][1] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int cx = cur.x;
			int cy = cur.y;
			int dist = cur.dist;
			
//			System.out.println(cx + " " + cy + " "+ dist);
			if(cx == N && cy == N) {
				return score[cx][cy];
			}
			
			for(int dic = 0; dic < 4; dic++	) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];
				
				if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
				if(map[nx][ny] == 0) {
					if(score[nx][ny] > score[cx][cy]) {
						pq.add(new Node(nx, ny, dist));
						score[nx][ny] = dist;
					}

				}else if(map[nx][ny] != 0) {
					if(score[nx][ny] > dist + map[nx][ny]) {
						pq.add(new Node(nx, ny, dist + map[nx][ny]));
						score[nx][ny] = dist + map[nx][ny];						
					}
				}
			}
		}
		
		return -1;
	}
}
