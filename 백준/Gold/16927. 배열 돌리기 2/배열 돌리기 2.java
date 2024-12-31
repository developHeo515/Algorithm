//BOJ16927 배열돌리기2, 골5
//겉배열에서 속배열까지 돌리려면 가로, 세로 값 중에서 더 작은 값을 min으로 설정
//겉배열에서 속배열까지 차례로 돌려야하는데 이때 겉면에서 1씩 줄이면 된다.
//회전이 너무 많을 경우 반복되는 패턴을 계산해 나머지 연산 적용
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
		//겉배열에서 속배열까지 차례로 돌려야하는데 이때 겉면에서 1씩 줄이면 된다.
		for(int i = 0; i < min/2; i++) {
			//회전이 너무 많을 경우 반복되는 패턴을 계산해 나머지 연산 적용	
			int num = R % (((N - 2 * i) + (M - 2 * i)) * 2 - 4);
			rotate(i, num);
		}
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void rotate(int start, int cnt) {
		for(int i = 0; i < cnt; i++) {
			int x = 1 + start;
			int y = 1 + start;
			
			int temp = map[x][y]; //초기값을 따로 저장해서 다돌고 마지막 위치에 넣어야함
			
			int dic = 0;
			while(dic < 4) {
				int nx = x + dx[dic];
				int ny = y + dy[dic];
				
				//범위 체크
				if(nx >= 1 + start && ny >= 1 + start && nx <= N - start && ny <= M - start) {
//					System.out.println("Ddd" + nx + " " + ny);
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				}
				else {
					dic++;
				}
			}
			
			map[x+1][y] = temp; //다돌고 마지막 위치에 초기값 넣기
		}
	}
}
