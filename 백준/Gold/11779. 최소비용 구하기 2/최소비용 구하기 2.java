//BOJ11779 최소비용 구하기 2,  골3
//다익스트라 알고리즘
//경로를 저장하기 위해 배열과 스택을 활용
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	static int n, m;
	static ArrayList<Node>[] nodeList;
	static int[] best;
	static int[] route;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		best = new int[n+1];
		route = new int[n+1];
		nodeList = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
			best[i] = 987654321;
			route[i] = -1;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(to, cost)); //단방향
//			nodeList[to].add(new Node(from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, end);
		
		//출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
		bw.write(best[end] + "\n");
		
		//경로 저장을 위해 배열과 스택을 활용
		Stack<Integer> stack = new Stack<>();
		int idx = end;
		while(true) {
			if(idx == 0) break;
			
//			System.out.print(idx + " ");
			stack.push(idx);
			idx = route[idx];
		}
		//최소 비용을 갖는 경로에 포함되어있는 도시의 개수를 출력한다. 
		bw.write(stack.size() + "\n");
		
		//최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력한다.
		while(!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		best[start] = 0;
		route[start] = 0; //시작지점
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;
			int cost = cur.cost;
			
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ시간초과 막기 위해 dummy 제거 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			if(best[to] < cost) continue; 
			
			for(Node next : nodeList[to]) {
				if(best[next.to] > cost + next.cost) {
					best[next.to] = cost + next.cost;
					route[next.to] = to; //경로 저장
					pq.add(new Node(next.to, best[next.to]));
				}
			}
			
		}
//		for(int i = 1; i <= n; i++) {
//			System.out.println(best[i]);
//		}
//		for(int i = 1; i <= n; i++) {
//			System.out.print(route[i] + " ");
//		}
	}
}
