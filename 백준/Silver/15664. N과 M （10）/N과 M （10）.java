//BOJ15663 N과 M(9)
//HashSet 사용하지 않는 방법
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, selected;
	static boolean[] visited;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		selected = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		
		func(0, 0);
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int depth, int start) throws IOException {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				bw.write(selected[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		int before = 0;
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				if(before != arr[i]) {
					visited[i] = true;
					selected[depth] = arr[i];
					before = arr[i];
					func(depth+1, i+1);			
					visited[i] = false;
				}

			}
		}
	}
}
