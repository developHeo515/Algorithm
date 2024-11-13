// 백준 15655 N과 M(6) 실버3
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int []input;
	static int []ans;
	static boolean []isSelect;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		ans = new int[M];
		isSelect = new boolean[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
//		System.out.println(Arrays.toString(input));
		dfs(0, 0);
	}
	static void dfs(int depth, int start) {
		if(depth == M) {
			for(int num : ans) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!isSelect[i]) {
				isSelect[i] = true;
				ans[depth] = input[i];
				dfs(depth+1, start+1);
				isSelect[i] = false;
				start+=1;
			}
		}
	}
}
