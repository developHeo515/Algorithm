//BOJ13913 숨바꼭질4, 골드4
//기존 숨바꼭질 문제에서 BFS 최단거리 경로를 저장하는 배열을 사용
//경로 기록은 순서대로 구하기 위해 stack에 담았다가 pop하면된다.
import java.io.*;
import java.util.*;

public class Main {
	static class P{
		int location;
		int cnt;
		public P(int location, int cnt) {
			this.location = location;
			this.cnt = cnt;
		}
	}
	static int[] point, parent;
	static int N, K, time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		point = new int[100000+1];
		parent = new int[100000+1];
		time = bfs();
		
		bw.write(time+"\n");
		
		//순서대로 구하기 위해 stack에 담았다가 pop하면된다.
		Stack<Integer> stack = new Stack<>();
		stack.push(K);
		int index = K;
		
		while(index != N) {
			index = parent[index];
			stack.push(index);
		}
		
		while(!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int bfs() {
		if(N == K) return 0; // 0, 0일 때 예외 케이스 처리해줘야한다.
		Queue<P> q = new LinkedList<>();
		q.add(new P(N, 0));
		
		while(!q.isEmpty()) {
			P cur = q.poll();
			int location = cur.location;
			int cnt = cur.cnt;
			
//			System.out.print(location  +  "-");
			
			if(location-1 >= 0) {
				if(point[location-1] == 0 && location-1 != N) { //이동한 위치가 수빈이 원래 위치 아니라면 1초후 X-1로 이동
					if(location-1 ==  K) { //동생위치 찾았을 때
						time = cnt+1;
						parent[location-1] = location;
						return time;
					}
					point[location-1] = cnt+1;
					q.add(new P(location-1, cnt+1));
					parent[location-1] = location;
				}
			}
			
			if(location+1 <= 100000) {
				if(point[location+1] == 0 && location+1 != N) { //이동한 위치가 수빈이 원래 위치 아니라면 1초후 X+1로 이동
					if(location+1 ==  K) { //동생위치 찾았을 때
						time = cnt+1;
						parent[location+1] = location;
						return time;
					}
					point[location+1] = cnt+1;
					q.add(new P(location+1, cnt+1));
					parent[location+1] = location;
				}
			}
			
			if(location * 2 <= 100000) {
				if(point[location*2] == 0 && location*2 != N) { //이동한 위치가 수빈이 원래 위치 아니라면 1초후 2*X로 이동
					if(location*2 ==  K) { //동생위치 찾았을 때
						time = cnt+1;
						parent[location*2] = location;
						return time;
					}
					point[location*2] = cnt +1;
					q.add(new P(location*2, cnt+1));
					parent[location*2] = location;
				}
			}
		}
		return -1;
	}
}
