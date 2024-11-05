//BOJ23288 주사위 굴리기 2, 골드3
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, ans;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북 (시계방향)
	static int[] dy = {1, 0, -1, 0};
	static int[] dice = new int[6+1];
	static int diceBottom, curX, curY, dic;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dice[1] = 2;
		dice[2] = 1;
		dice[3] = 5;
		dice[4] = 6;
		dice[5] = 4;
		dice[6] = 3;
		diceBottom = 6;
		ans = 0;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		curX = 1;
		curY = 1;
		dic = 0; //시작은 동쪽
		
		//주사위 굴리기 시작
		for(int i = 1; i <= K; i++) {
			//주사위가 구른 위치가 범위 밖으로 나가는지 사전에 체크
			directionCheck();
			
			curX = curX + dx[dic];
			curY = curY + dy[dic];
			tumble(dic);
			diceBottom = dice[4];
//			System.out.println(curX + " " + curY);
			
			//동서남방향 체크(BFS)
			boolean[][] visited = new boolean[N+1][M+1];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {curX, curY});
			visited[curX][curY] = true;
			int sequenceNum = map[curX][curY];
			int seqCount = 1;
			
			while(!q.isEmpty()) {
				int[] curArr = q.poll();
				int cX = curArr[0];
				int cY = curArr[1];
				
				for(int d = 0; d < 4; d++) {
					int nextX = cX + dx[d];
					int nextY = cY + dy[d];
					
					if(nextX < 1 || nextY < 1 || nextX > N || nextY > M) continue;
					if(visited[nextX][nextY]) continue;
					if(map[nextX][nextY] != sequenceNum) continue;
					
					//연속성일때
//					System.out.println(nextX + " " + nextY);
					seqCount++;
					visited[nextX][nextY] = true;
					q.add(new int[] {nextX, nextY});
				}
			}
//			System.out.println(seqCount);
			
			//점수 추가
			ans += (sequenceNum * seqCount);
			
			if(diceBottom > map[curX][curY]) {
				dic++;
				if(dic == 4)
					dic = 0;
			}
			else if(diceBottom < map[curX][curY]) {
				dic--;
				if(dic == -1)
					dic = 3;
			}
		}
		
		
		bw.write(ans+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void tumble(int direction) {
		int temp;
		if(direction == 0) { //동쪽일때
			temp = dice[4]; //바닥면 먼저 저장
			dice[4] = dice[6];
			dice[6] = dice[2];
			dice[2] = dice[5];
			dice[5] = temp;
		}else if(direction == 1) { //남쪽일때
			temp = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp;
		}else if(direction == 2) { //서쪽일때
			temp = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[6];
			dice[6] = temp;
		}else if(direction == 3) { //북쪽일때
			temp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = temp;
		}
	}
	static void directionCheck() {
		int x = curX;
		int y = curY;
		
		x = curX + dx[dic];
		y = curY + dy[dic];
		
		if(x < 1) { //북쪽 가다가 벗어났을때
			dic = 1; //남쪽으로 변경
		}
		else if(x > N) { //남쪽 가다가 벗어났을때
			dic = 3; //북쪽으로 변경
		}
		else if(y < 1) { //서쪽 가다가 벗어났을때
			dic = 0; //동쪽으로 변경
		}
		else if(y > M) { //동쪽 가다가 벗어났을때
			dic = 2; //서쪽으로 변경
		}
	}
}
