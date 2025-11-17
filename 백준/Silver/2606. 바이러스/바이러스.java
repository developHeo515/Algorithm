//BOJ 2606 바이러스 실버3
import java.io.*;
import java.util.*;	

public class Main {
	static int N, M, cnt;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}


		for(int j = 1; j <= M; j++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
//		System.out.println(Arrays.toString(graph));
		cnt = 0;
		
		dfs(1);
		System.out.println(cnt);
	}
	static void dfs(int start) {
		visited[start] = true;
		for(int cur : graph[start]) {
			if(!visited[cur]) {
				visited[cur] = true;
				cnt++;
				dfs(cur);
			}
		}
	}
}
