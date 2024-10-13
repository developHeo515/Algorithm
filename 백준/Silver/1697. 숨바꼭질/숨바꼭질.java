//BOJ1697 숨바꼭질, 실버1
import java.io.*;
import java.util.*;

public class Main {
	static int N, K, time;
	static int[] point, parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = 0;
		point = new int[100001];
		parent = new int[100001];
		
		time = bfs();
	
		bw.write(time + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int bfs() {
		if(N == K) return 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		point[N] = 1; //구분을 위해 해둠
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int next;
			
			for(int i = 0; i < 3; i++) {
				if(i == 0) next = cur - 1;
				else if(i == 1) next = cur + 1;
				else next = cur * 2;
				
				if(next < 0 || next > 100000) continue;
				if(next == K) {
					return point[cur];
				}else if(point[next] != 0) { //방문한적있을때
					continue;
				}else if(point[next] == 0) {
					point[next] = point[cur] + 1;
					q.add(next);
				}
			}
			
		}
		
		return -1;
	}
}
