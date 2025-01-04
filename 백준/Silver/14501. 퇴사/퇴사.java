//BOJ14501 퇴사, 실3
//DFS 문제
import java.io.*;
import java.util.*;

public class Main {
	static int[] T, P;
	static int N, res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		T = new int[N+1];
		P = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		res = 0;
		dfs(1, 0);
		
		bw.write(res+"\n");
		bw.flush();
		bw.close();
		br.close();		
	}
	static void dfs(int day, int sum) {
		if(day == N+1) {
			res = Math.max(res, sum);
			return;
		}
		
		//상담 하는 경우
		if(day + T[day] <= N+1) {
			dfs(day + T[day], sum + P[day]);
		}
		//상담 안하는 경우
		if(day+1 <= N+1) {
			dfs(day + 1, sum);
		}
		
		
	}
	
}

