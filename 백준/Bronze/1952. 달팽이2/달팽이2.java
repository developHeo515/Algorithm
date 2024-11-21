import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[M+1][N+1];
		int[][] map = new int[M+1][N+1];
		
		int cx = 1;
		int cy = 1;
		int dic = 0;
		int cnt = 0;
		int sum = 0;
		arr[cx][cy] = true;
		sum = 1;
		
		while(dic < 4) {
			int nx = cx + dx[dic];
			int ny = cy + dy[dic];
			
			if(sum == M * N) {
				System.out.println(cnt);
				return;
			}
			
			if(nx > 0 && ny > 0 && nx <= M && ny <= N  && !arr[nx][ny]) {
				sum++;
				arr[nx][ny] = true;
				cx = nx;
				cy = ny;
			}else {
				dic++;
				cnt++;
			}
			
			if(dic == 4){
				dic = 0;
			}
		}
		
		
		
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
