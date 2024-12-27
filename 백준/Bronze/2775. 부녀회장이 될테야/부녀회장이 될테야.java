//BOJ2775 부녀회장이 될테야, 브1
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[k+1][n+1];
			
			for(int j = 1; j <= n; j++) {
				dp[0][j] = j;
			}
			
			for(int i = 1; i <= k; i++) {
				int num  = 0;
				for(int j = 1; j <= n; j++) {
					num += dp[i-1][j];
					dp[i][j] += num;
				}
			}
			
//			for(int i = 1; i <= k; i++) {
//				for(int j = 1; j <= n; j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			bw.write(dp[k][n] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
