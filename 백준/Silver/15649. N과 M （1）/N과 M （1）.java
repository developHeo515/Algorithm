//BOJ15649 N과 M(1)
//백트래킹 다시 풀어보기
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, selected;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		selected = new int[M];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		func(0);
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = arr[i];
				func(depth+1);		
				visited[i] = false;
			}
		}
	}
}
