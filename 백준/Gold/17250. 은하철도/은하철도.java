//BOJ17250 은하철도, 골드4
// 유니온 파인드 문제
import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int[] parent, cost;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		cost = new int[N+1];
		visited = new boolean[N+1];
		for(int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			int costNum = Integer.parseInt(br.readLine());
			cost[i]	= costNum;
		}
		
		for(int e = 0; e < M; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
			bw.write(cost[find(a)] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		if(a < b) {
			parent[b] = a;
			cost[a] += cost[b];
//			System.out.println(a + " " + b + " " + cost[a]);
		}
		else {
			parent[a] = b;
			cost[b] += cost[a];
//			System.out.println(a + " " + b + " " + cost[b]);
		}
	}
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
