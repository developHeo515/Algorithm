//BOJ2617 구슬 찾기, 골드4
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int half;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		half = (N/2) + 1;
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//a > b
			map[a][b] = 1; //a가 b보다 큼
			map[b][a] = -1; //b가 a보다 작음 
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(map[i][k] == map[k][j] && map[j][k] != 0)
						map[i][j] = map[i][k];
				}
			}
		}
		
		 int[] big = new int[N+1];
		 int[] small = new int[N+1];
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//					System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 1) 
					big[i]++;
				
				if(map[i][j] == -1)
					small[i]++;
			}
		}
		int ans = 0;
		
		for(int i = 1; i <= N; i++) {
			if(big[i] >= half) ans++;
			if(small[i] >= half) ans++;
		}
		
		bw.write(ans +"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
