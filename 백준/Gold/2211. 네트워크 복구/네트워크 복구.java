//BOJ2211 네트워크 복구
//다익스트라 알고리즘
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
//		int from;
		int to;
		int cost;
		
		public Node(int to, int cost) {
//			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static class Temp{
		int from;
		int to;
		int cost;
		
		public Temp(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int N, M;
	static ArrayList<Node>[] nodeList;
	static Temp[] best;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N+1];
		best = new Temp[N+1];
		
		for(int i = 1; i <= N; i++)	{
			nodeList[i] = new ArrayList<>();
//			best[i].from = i;
//			best[i].to = i;
//			best[i].cost = 987654321;
			best[i] = new Temp(i, i, 987654321); //이렇게 초기화 해줘야한다.
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodeList[from].add(new Node(to, cost)); //양방향 연결
			nodeList[to].add(new Node(from, cost));
		}
		
		dijkstra();
		
		bw.write(N-1 + "\n");
		for(int i = 2; i <= N; i++)	{
			bw.write(best[i].from + " " + best[i].to + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0)); //초기값 세팅 1번 노드 스타트
		best[1].cost = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;
			int cost = cur.cost;
			
			if(cost > best[to].cost) continue; //dummy 제외
			
//			System.out.println(to + " " + cost);
			
			for(Node next : nodeList[to]) {
				if(best[next.to].cost > cost + next.cost) {
					best[next.to].from = to;
					best[next.to].to = next.to;
					best[next.to].cost = cost + next.cost;
					pq.add(new Node(next.to, best[next.to].cost));
				}
			}
		}
//		for(int i = 2; i <= N; i++)	{
//			System.out.println(best[i].from + " - " + best[i].to);
//		}
	}
}
