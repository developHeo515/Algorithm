//BOJ2075 N번째 큰 수
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				pq.add(num);
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(i == N) {
				bw.write(pq.poll() + "\n");
			}
			else {
				pq.poll();
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
