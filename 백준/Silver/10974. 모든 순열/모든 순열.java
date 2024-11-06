//BOJ10974 모든 순열, 실버3
// 순조부 문제
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, select;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		select = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		dfs(0);
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int depth) {
		if(depth == N) {
			for(int j = 1; j <= N; j++) {
				System.out.print(select[j] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				select[depth+1] = arr[i];
				visited[i] = true;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
}
