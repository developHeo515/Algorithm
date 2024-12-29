//BOJ12834 주간 미팅, 골4
//다익스트라 알고리즘
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int N, V, E, A, B;
	static int[] person;
	static ArrayList<Node>[] nodeList;
	static int[] dist;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		person = new int[N+1];
		nodeList = new ArrayList[V+1];
		dist = new int[V+1];
		
		for(int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(to, cost));
			nodeList[to].add(new Node(from, cost));
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			int start = person[i];
			int p = 0;
			p += dijkstra(start, A);
			p += dijkstra(start, B);
//			System.out.println(p);
			result += p;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int dijkstra(int start, int end) {
//		System.out.println("zzz");
		Arrays.fill(dist, INF); //다익스트라 할때마다 dist 거리값 초기화 해줘야함
		dist[start] = 0; //자기 위치는 0을로 초기화
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;
			int cost = cur.cost;
			
			if(to == end) {
				return cost;
			}
			
			for(Node next : nodeList[to]) {
				if(dist[next.to] > cost + next.cost) {
//					System.out.println(cost + " - " + next.cost);
					dist[next.to] = cost + next.cost;
					pq.add(new Node(next.to, cost+next.cost));
				}
			}
		}
		
		return -1;
	}
}
