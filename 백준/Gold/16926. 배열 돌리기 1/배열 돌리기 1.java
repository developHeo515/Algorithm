//BOJ16926 배열돌리기1, 골5
//겉배열에서 속배열까지 돌리려면 가로, 세로 값 중에서 더 작은 값을 min으로 설정
//겉배열에서 속배열까지 차례로 돌려야하는데 이때 겉면에서 1씩 줄이면 된다.
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static int min;
	static int[][] map;
	
	static int[] dx = {0, 1, 0, -1}; 
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Math.min(N, M);
		for(int i = 0; i < R; i++) {
			rotate();
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void rotate() {
		//겉배열에서 속배열까지 차례로 돌려야하는데 이때 겉면에서 1씩 줄이면 된다.
		for(int t = 0; t < min/2; t++) {
			int x = 1 + t;
			int y = 1 + t;
			
			int temp = map[x][y]; //초기값을 따로 저장해서 다돌고 마지막 위치에 넣어야함
			
			int idx = 0;
			while(idx < 4) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				//범위 체크
				if(nx >= 1 + t && ny >= 1 + t && nx <= N - t && ny <= M - t) {
//					System.out.println("Ddd" + nx + " " + ny);
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				}
				else {
					idx++;
				}
			}
			
			map[x+1][y] = temp; //다돌고 마지막 위치에 초기값 넣기
		}
	}
}
