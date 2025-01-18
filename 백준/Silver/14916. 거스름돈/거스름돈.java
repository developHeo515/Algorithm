//BOJ14916 거스름돈, 실5
//DP
import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int x, y;
            x = y = INF;
            if(i-2>=0 && dp[i-2]!=-1) x = dp[i-2];
            if(i-5>=0 && dp[i-5]!=-1) y = dp[i-5];
            if(x==INF && y==INF) dp[i] = -1;
            else dp[i] = Math.min(x, y) + 1;
        }

        bw.write(dp[n]+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
