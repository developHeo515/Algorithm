//BOJ1021 회전하는 큐
import java.io.*;
import java.util.*;

public class Main {
	static LinkedList<Integer> que = new LinkedList<>();
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		arr = new int[M];
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = func(M);
		
		bw.write(res +"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int func(int M) {
		int cost = 0;
		
		for(int i = 0; i < M; i++) { //인덱스를 기준으로 잡음
			int targetIdx = que.indexOf(arr[i]);
			int middleIdx;
			
			if(que.size() % 2 == 0) {
				middleIdx = que.size() / 2 - 1;
			}else {
				middleIdx = que.size() / 2;
			}
			
			if(targetIdx <= middleIdx) {
				for(int j = 0; j < targetIdx; j++) {
					int tmp = que.pollFirst();
					que.offerLast(tmp);
					cost++;
				}
			}
			else {
				for(int j = 0; j < que.size() - targetIdx; j++) {
					int tmp = que.pollLast();
					que.offerFirst(tmp);
					cost++;
				}
			}
			
			que.pollFirst();
		}
		
		return cost;
	}
}
