//BOJ17472 다리 만들기2, 골드1
//프림 알고리즘 사용, 섬영역 연결은 BFS, 섬 다리 연결은 DFS, 최소 스패닝 트리는 프림 사용
//생각해야 할 부분이 많아서 시간이 많이 걸렸다. 2시간 30분
//그래도 스스로 풀었다..!
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int from;  //프림에선 from 없어도 되는데 디버깅하면서 확인하려고 넣음
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
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Node>[] nodeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//섬 연결
		visited = new boolean[N+1][M+1];
		int landNumber = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					connect(i, j, landNumber++);
				}
			}
		}
		//섬 4개면 landNumber는 5
		nodeList = new ArrayList[landNumber];
		for(int i = 1; i <= landNumber-1; i++) {
//			nodeList[i] = new ArrayList<Node>();
			nodeList[i] = new ArrayList<>();
		}
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//섬끼리의 모든 다리 탐색
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(map[i][j] != 0) {
					dfs(i, j, i, j, 0, 0);
					dfs(i, j, i, j, 1, 0);
					dfs(i, j, i, j, 2, 0);
					dfs(i, j, i, j, 3, 0);
				}
			}
		}
//		for (int i = 1; i <= landNumber - 1; i++) {
//			for (Node cur : nodeList[i]) {
//				System.out.println(i + " " + cur.to + " " + cur.cost);
//			}
//		}
		
		int[] check = new int[landNumber];
		for(int i = 1; i <= landNumber - 1; i++) {
			check[i] = i;
		}
		
		
		ans = 0;
		boolean[] visit = new boolean[landNumber];
//		System.out.println("프림시작");
		prim(visit, check);
		
		for(int i = 1; i <= landNumber - 1; i++) {
			if(check[i] != 1) {
				ans = -1;
			}
		}
		

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	//프림 알고리즘
	static void prim(boolean[] visit, int[] check) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 1, 0)); //시작은 1번섬, 다리 길이 0으로 시작
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;
			int cost = cur.cost;
			
			//길이 더하는거 여기서 해줘야함 pq라 정렬된 상태에서 더하기
			if(visit[to]) continue;
			visit[to] = true; //방문처리 해줘야함
			ans += cost;
			check[to] = 1; //모두 연결됐는지 확인하기 위해 초기값 1번 섬 넣어준다.
//			System.out.println(cur.from + " " + cur.to + " "  + cur.cost);
			
			for(Node next : nodeList[to]) {
				if(visit[next.to]) continue;
//				System.out.println(next.from + " " + next.to + " "  + next.cost);
				pq.add(next);
//				visit[next.to] = true; //여기서 방문처리 해버리면 뒤에 나오는 가중치 낮은 애들을 볼 수 없다.
//				ans += next.cost;  //여기서 더하면 pq하는 의미가 없어짐 나오는 애들 다 더하는거라
			}
		}
	}
	
	
	//초기값 init x와 y
	static void dfs(int initX, int initY, int x, int y, int dic, int depth) {
		int nx = x + dx[dic];
		int ny = y + dy[dic];
		
		if(nx < 1 || ny < 1 || nx > N || ny > M) return;
		if(map[nx][ny] == 0) {
			dfs(initX, initY, nx, ny, dic, depth+1);
		}else {
			if(map[initX][initY] == map[nx][ny]) { //같은 섬 영역일 때
				return;
			}
			else if(map[initX][initY] != map[nx][ny] && depth >= 2) {
				// 간선 추가
				int from = map[initX][initY];
				int to = map[nx][ny];
				int cost = depth;
//				System.out.println(from + " " + to + " 길이 : " + cost + ", 방향 -" + dic);
				nodeList[from].add(new Node(from, to, cost));
				return;
			}
			else {
				return;
			}
		}
	}
	
	static void connect(int initX, int initY, int land) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {initX, initY});
		visited[initX][initY] = true;
		map[initX][initY] = land;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			
			for(int dic = 0; dic < 4; dic++) {
				int nx = cx + dx[dic];
				int ny = cy + dy[dic];
				if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
				if(map[nx][ny] == 0 || visited[nx][ny]) continue;
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				map[nx][ny] = land;
			}
		}
	}
}
