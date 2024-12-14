//BOJ1966 프린터 큐, 실버3
//구현 문제
import java.io.*;
import java.util.*;

public class Main {
//	static class Node implements Comparable<Node>{
//		int w;
//		
//		public Node(int w) {
//			this.w = w;
//		}
//		
//		@Override
//		public int compareTo(Node o) {
////			return this.w - o.w;
//			return o.w - this.w;
//		}
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			Queue<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int qnum = Integer.parseInt(st.nextToken());
				
				q.add(new int[]	{j, qnum});
			}
			
			int cnt = 0;
			while(true) {
				int []cur = q.poll();
				boolean flag = true;
				
				for(int [] curQ : q) {
					if(curQ[1] > cur[1]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(cur[0] == M) break;
				}
				else {
					q.add(cur);
				}
			}
			
//			while(!pq.isEmpty()) {
//				Node cur = pq.poll();
//				bw.write(cur.w + " ");
//			}
			bw.write(cnt +"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
