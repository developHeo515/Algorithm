//BOJ1010 다리 놓기, 실5
//조합을 사용해야하는 dp 문제
import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); 
			
			dp = new int[M+1][N+1];
			
			bw.write(comb(M, N) + "\n");
		}
		
		bw.flush();
		bw.close();
		bw.close();
	}
	static int comb(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}
}
