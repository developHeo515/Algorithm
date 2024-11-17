//BOJ11780 플로이드2, 골드2
//경로를 넣는 과정이 쉽지 않았다. 풀이 보면서 이해함
import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 987654321;
	static int[][] path;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][N+1];
		int[][] path = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				arr[i][j] = INF;
				path[i][j] = INF;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(arr[a][b] > c)
				arr[a][b] = c;
//			System.out.println(a + " " + b + " " + c);
			path[a][b] = a;
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				if(arr[i][j] == INF)
//					System.out.print(0 + " ");
//				else
//					System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(arr[i][j] == INF)
					System.out.print(0 + " ");
				else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(path[i][j] == INF) bw.write(0 + "\n");
				else {
					int end = j;
					stack.push(end);
					while(i != path[i][end]) {
						end = path[i][end];
						stack.push(end);
					}
					stack.push(i); //마지막인 시작점도 넣어야함
					bw.write(stack.size() + "");
					while(!stack.isEmpty()) {
						bw.write(" " + stack.pop());
					}
					bw.write("\n");
				}
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
