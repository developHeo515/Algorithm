//BOJ16938 캠프 준비, 골드5
import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, X, ans;
	static int[] arr = new int[16];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N;  i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			ans += func(arr[i], i, arr[i], arr[i]);
		}
		
		bw.write(ans+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int func(int sum, int idx, int min, int max) {
		int result = 0;
		min = Math.min(arr[idx], min);
		max = Math.max(arr[idx], max);
		
		if(L <= sum && (max-min) >= X)
			result += 1;
		
		if(idx == N) {
			return result;
		}
		
		for(int i = idx+1; i <= N; i++) {
			if(sum + arr[i] <= R) {
				result += func(sum+arr[i], i, min, max);
			}
		}
		
		return result;
	}
}
