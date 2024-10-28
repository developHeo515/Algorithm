//BOJ1182 부분수열의 합, 실버2
import java.io.*;
import java.util.*;

public class Main {
	static int[] num;
	static int N, S;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		if(S == 0) bw.write((ans - 1)+"\n"); //S가 0일때랑 겹치는 경우 때문에 -1로 해줌
		else bw.write(ans+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S) ans++;
			return;
		}
		
		dfs(depth+1, sum + num[depth]);
		dfs(depth+1, sum);
	}
}
