//BOJ6497 전력난, 골드4
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int cost;
		
		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int N, M, total;
	static int[] parent;
	static ArrayList<Node> nodeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		while(true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(M == 0 && N == 0) 
				break;
			nodeList = new ArrayList<>();
			
			int total = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				nodeList.add(new Node(from, to, cost));
				total += cost;
			}
			Collections.sort(nodeList);
			parent = new int[M+1];
			for(int i = 1; i <= M; i++) {
				parent[i] = i;
			}
			
			int minCost = 0;
			for(int i = 0; i < nodeList.size(); i++) {
				Node cur = nodeList.get(i);
				
				if(find(cur.from) != find(cur.to)) {
					minCost += cur.cost;
					union(cur.from, cur.to);
				}
			}
			bw.write((total - minCost) + "\n");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();	
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		else if(a < b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
	}
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
