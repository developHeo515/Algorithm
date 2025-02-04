//BOJ1531 투명, 실5
//구현, 시뮬
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] image = new int[101][101];
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i = x1; i <= x2; i++) {
				for(int j = y1; j <= y2; j++) {
					image[i][j] = image[i][j] + 1;
				}
			}
			
		}
		

		int cnt = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
//				System.out.print(image[i][j] + " ");
				if(image[i][j] <= M) {
					image[i][j] = 0;
				}
			}
//			System.out.println();
		}
		
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(image[i][j] != 0) {
					cnt++;
				}
			}
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
