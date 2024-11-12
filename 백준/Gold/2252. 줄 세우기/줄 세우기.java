//BOJ2252 줄 세우기, 골드3
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] nodeList;
	static int[] edgeCount, res;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodeList = new ArrayList[N+1];
		edgeCount = new int[N+1];
		res = new int[N+1];
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[a].add(b);
			edgeCount[b]++;
		}
		
		func();
		for(int i = 1; i <= N; i++) {
			bw.write(res[i] + " ");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void func() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(edgeCount[i] == 0) {
				q.add(i);
			}
		}
		
		int idx = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			res[idx++] = cur;
			
			for(int next : nodeList[cur]) {
				edgeCount[next]--;
				if(edgeCount[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}
