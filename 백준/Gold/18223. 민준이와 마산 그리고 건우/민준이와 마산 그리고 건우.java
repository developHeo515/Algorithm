//BOJ18223 민준이와 마산 그리고 건우, 골4
//다익스트라 알고리즘
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
//		int from;
		int to;
		int cost;
		
		public Node(int to, int cost)	{
//			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int V, E, P;
	static ArrayList<Node>[] nodeList;
	static int[] dist;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodeList[from].add(new Node(to, cost));
			nodeList[to].add(new Node(from, cost));
		}
		
		int shortest = 0;
		shortest = dijkstra(1, V);
		
		int gunwoo = 0;
		gunwoo += dijkstra(1, P);
		gunwoo += dijkstra(P, V);

		if(shortest == gunwoo) {
			bw.write("SAVE HIM" + "\n");
		}
		else {
			bw.write("GOOD BYE" + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int dijkstra(int start, int end) {
		init(); // 각 vertex 거리 초기화
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0)); //초기화값, 시작 노드에서 가중치 0에서 시작
		dist[start] = 0; //각 vertex 거리
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;
			int cost = cur.cost;
//			System.out.println(to + " " + cost);
			
			for(Node next : nodeList[to]) {
				if(dist[next.to] >= dist[to] + next.cost) {
					dist[next.to] = dist[to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		return dist[end];
	}
	static void init() {
		for(int i = 1; i <= V; i++) {
			dist[i] = INF;
		}
	}
}


