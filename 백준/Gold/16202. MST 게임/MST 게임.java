//BOJ16202 MST 게임, 골드3
//생각보다 애먹은 문제, MST 공부 다시해야할듯..
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
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

	static int N, M, K;
	static int[] parent;
	static int[] total;
	static ArrayList<Node> nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		nodeList = new ArrayList<>();

		for (int cost = 1; cost <= M; cost++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodeList.add(new Node(from, to, cost));
		}
//		Collections.sort(nodeList); // 어차피 가중치가 오름차순으로 들어가서 정렬 필요X
//		for (int i = 0; i < nodeList.size(); i++) {
//			Node cur = nodeList.get(i);
//			System.out.println(cur.from + " " + cur.to + " " + cur.cost);
//		}
		
		for(int k = 1; k <= K; k++) {
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			total = new int[N+1];
			
			//두 번째 턴부터 가장 작은 가중치 삭제
			if(k > 1) {
				nodeList.remove(0);
			}
			// MST 연결
			for(int i = 0; i < nodeList.size(); i++) {
				Node cur = nodeList.get(i);
//				System.out.println(cur.from + " " + cur.to + " " + cur.cost);
				union(cur.from, cur.to, cur.cost);
			}
			
//			for(int i = 1; i <= N; i++) {
//				System.out.print(find(parent[i])  + " ");
//			}
//			System.out.println();
			
//			//MST 확인
			boolean flag = true;
			int confirm = parent[1];
			for(int i = 1; i <= N; i++) {
				//실수한 부분 : 그냥 parent[i] 하면 MST 확인 못한다.
				//find(parent[i])해줘야 모두 연결됐는지 확인가능
				if(confirm != find(parent[i])) {  
					//MST 못찾는 상황
					flag = false;
				}
			}
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				ans += total[i];
			}
			
			if(flag) {
				bw.write(ans + " ");
			}else {
				bw.write(0 + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean union(int a, int b, int cost) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		if (a < b) {
			parent[b] = a;
			total[a] += cost;
		} else {
			parent[a] = b;
			total[b] += cost;
		}
		return true;
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
