//BOJ20500 Ezreal 여눈부터 가네 ㅈㅈ, 골5
// DP 문제, 점화식 구하는게 넘 어렵;;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		
		//15의 배수 = 3과 5의 공배수
		//3의 배수의 성질은 각 자릿수의 합이 3으로 나누어떨어진다.
		//5의 배수의 성질은 일의 자리가 0 또는 5이다.
		//1과 5로만 구현을 해야 하므로 일의 자릿수는 무조건 5가 되어야 함을 알 수 있다.
		
		if(N == 1) {
			bw.write(0 + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		if(N == 2) {
			bw.write(1 + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[2][2] = 0;
		
		for(int i = 3; i <= N; i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 1000000007;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 1000000007;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 1000000007;
		}
		
		bw.write(dp[N][0] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
