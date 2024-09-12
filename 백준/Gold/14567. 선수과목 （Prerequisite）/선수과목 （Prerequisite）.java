//BOJ14567 선수과목 골드5, 2시간 걸림
//위상정렬을 공부하며 사용해보았다.
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] edgeCount;
	static int[] res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		edgeCount = new int[N+1];
		res = new int[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
//		System.out.println(N+" "+M+" "+list);
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			edgeCount[b]++; // 이 부분 실수했음 edgeCount[a]라고 해서 그래프 검사를 할 수 없었다.
		}
		
//		System.out.println(Arrays.deepToString(list));
//		System.out.println(Arrays.toString(edgeCount));
//		System.out.println();
		
//		for(int i = 0; i <= N; i++) {
//			//돌면서 찾은 그래프의 들어야할 선수과목 수를 줄인다.
//			if(list[i].size() == 0) continue;
//			System.out.println(list[i]);
//			for(int j = 0; j < list[i].size(); j++) {
//				System.out.println(list[i].get(j));
//			}
//			//찾은 그래프 중에 size가 0이면 큐에 넣는다.
//		}
		
		func();
		for(int i = 1; i <= N; i++) {
			System.out.print(res[i] +" ");
		}
	}
	static void func() {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 1;
		
		for(int i = 1; i <= N; i++) {
			if(edgeCount[i] == 0) {
				q.add(i);
			}
			
		}
		
		
		while(!q.isEmpty()) {
			//돌면서 찾은 그래프의 들어야할 선수과목 수를 줄인다.
			// 큐에 있는 만큼 다 돌아야 한 학기가 끝난거다.
			int size = q.size();

			//한 학기 시작
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				res[cur] = cnt;
//				System.out.println(cur);
				for(int num : list[cur]) {
					edgeCount[num]--;
					//찾은 그래프 중에 size가 0이면 큐에 넣는다.
					if(edgeCount[num] == 0) {
						q.add(num);
						
					}
				}
			}
			cnt++; //한 학기 끝나서 cnt ++ 해줌
				
				
			
			
		}
		
		
	}
}
