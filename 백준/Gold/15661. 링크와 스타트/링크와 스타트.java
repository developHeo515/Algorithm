//BOJ15661 링크와 스타트
//BOJ14889 스타트와 링크는 정확히 N/2 로 팀이 나눠진다.
//이문제는 홀수로 팀을 나눌 수 있기에 한팀에 최소 1명일때부터 N-1명 일때까지 DFS를 돌리면 된다.
//for(t = 1; t < N; t++) {
//	dfs(1, 0);
//}
import java.io.*;
import java.util.*;


public class Main {
	static int N, ans, t;
	static int[][] map;
	static boolean[] visit;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		ans = INF;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(t = 1; t < N; t++) {
			dfs(1, 0);
		}
			
		
		
		bw.write(ans+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int start, int depth) {
		if(depth == t) {
//			System.out.println(t);
			diff();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i+1, depth+1);  // 실수한 부분 -> dfs(start+1, depth+1) 해버림
				visit[i] = false;
			}
		}
	}
	
	static void diff() {
		int teamA = 0;
		int teamB = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				if (visit[i] == true && visit[j] == true) {
//					System.out.println(i + " " + j);
					teamA += map[i][j];
					teamA += map[j][i];
				}
				else if (visit[i] == false && visit[j] == false) {
					teamB += map[i][j];
					teamB += map[j][i];
				}
				
			}
		}
		
//		System.out.println(teamA + " " + teamB);
		int num = Math.abs(teamA - teamB);
		ans = Math.min(ans, num);
		if(ans == 0) {
			System.out.println(ans);
			System.exit(0);
		}
	}
}


