//BOJ10826 피보나치 수 4, 실5
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger[] dp = new BigInteger[10001];
		
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.ONE;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		
		bw.write(dp[N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
