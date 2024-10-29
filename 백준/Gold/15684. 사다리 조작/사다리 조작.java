//BOJ15684 사다리 조작, 골드3
// 백트래킹, 브루트 포스
//시간초과 9% 해결시도
//DFS 에서 사다리들을 뽑을 때 이중 for문으로 뽑아서 헷갈렸는데,
//사다리를 놓는건 조합이라 DFS에 인덱스를 같이 호출해야 했습니다.
//18번째줄에 index를 같이 호출하고, 밑에 사다리를 뽑는 for문에서 index부터 탐색하도록 해야합니다... 저건 순열입니다. 
//DFS를 재귀호출할 때마다 0부터 계속 탐색해서 시간초과가 났었나 봅니다.
import java.io.*;
import java.util.*;

public class Main {
	static class Ladder {
		int x;
		int y;
		boolean visit;
		int moveX;
		int moveY;
		public Ladder(int x, int y, boolean visit, int moveX, int moveY) {
			this.x = x;
			this.y = y;
			this.visit = visit;
			this.moveX = moveX;
			this.moveY = moveY;
		}
	}
	static int N, M, H, ans;
	static final int INF = 987654321;
	static Ladder[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = INF;
		arr = new Ladder[H+1][N+1];
		
		for(int i = 1; i <= H; i++) {
			for(int j = 1; j <= N; j++) {
				arr[i][j] = new Ladder(i, j, false, i, j);
			}
		}
		
		//가로선 연결
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//사다리 연결
			arr[a][b] = new Ladder(a, b, true, a, b+1);
			arr[a][b+1] = new Ladder(a, b+1, true,  a, b);
//			System.out.println(arr[a][b+1].moveX + " " + arr[a][b+1].moveY);
		}
		
//		for(int i = 1; i <= H; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(arr[i][j].visit + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("Dfs 전");
		dfs(0); //depth와 index 
		
		if(ans == INF) {
			ans = -1;
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int depth) {
		if(depth >= ans) {  //시간초과 9% 해결시도 2
			return;
		}
		if(depth == 4) { //사다리 개수 4개면 그냥 다음 케이스 검색
			return;
		}
		
		boolean flag = true;
		//사다리 타기 시작
		for(int i = 1; i <= N; i++) {
			//사다리 타기 시작값
			int goalY = i;  //목표하는 결과값
			int curY = i; //타겟값
			
			for(int j = 1; j <= H; j++) {
				if(arr[j][curY].visit) { //사다리 있으니 옮긴 위치로 내려가서 넣어줌
//					System.out.println(arr[j][curY].moveX + " " +arr[j][curY].moveY);
					curY = arr[j][curY].moveY;
//					System.out.println(curY);
				}
			}
//			System.out.println();
			if(curY != goalY) {
				flag = false;
				break; //시간초과 9% 해결시도 1
			}
		}
		
		if(flag) { //모든 i번째 사다리가 i번째로 내려올때
			ans = depth;
//				for(int i = 1; i <= H; i++) {
//					for(int j = 1; j <= N; j++) {
//						System.out.print(arr[i][j].visit + " ");
//					}
//					System.out.println();
//				}
//				System.out.println(ans);
//				System.out.println();
//			ans = Math.min(ans, depth);
			return;
		} 
		//하나라도 실패했으니 사다리 추가
		if(depth < 3) { //depth가 3일 경우 탐색을 할 필요가 없음.(3일 때도 탐색하면 8% 시간초과 발생)
		    //DFS 돌며 재귀호출할 때마다 0부터 계속 탐색해서 시간초과날 수 있다.
			for(int i = 1; i <= H; i++) {
				//세로선 5개면 4개까지 검사하면 4-5번째 사다리 연결 가능하다.
				//5개까지 다 검사하면 5-6번째 사다리 연결로 index 초과함
				for(int j = 1; j <= N-1; j++) {
					if(arr[i][j].visit) continue;
					if(arr[i][j+1].visit) continue;
					
					//new Ladder로 넣어줌
					arr[i][j] = new Ladder(i, j, true, i, j+1);
					arr[i][j+1] = new Ladder(i, j+1, true, i, j);
					
					//이렇게 사다리 맵 고치니 값이 제대로 안들어가서 new Ladder로 넣어줌
//						arr[i][j].moveY = j+1;
//						arr[i][j].visit = true;
//						arr[i][j+1].moveY = j;
//						arr[i][j+1].visit = true;
					dfs(depth+1); //앞에 칸도 이미 검사했으니 2칸 넘는다.
					//나오면 사다리 추가했던거 빼기
					arr[i][j].visit = false;
					arr[i][j+1].visit = false;
				}
			}
		}
		
		

		
	}
}
