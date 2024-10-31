//BOJ11265 끝나지 않는 파티
//플로이드 워샬 알고리즘
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] area = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(area[i][j] + " ");
//			}
//			System.out.println();
//		}
			
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(area[i][j] > area[i][k] + area[k][j]) {
						area[i][j] = area[i][k] + area[k][j];
					}
				}
			}
		}

//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(area[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(area[a][b] <= c) {
//				System.out.println(area[a][b]);
				bw.write("Enjoy other party\n");
			}else{
				bw.write("Stay here\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
