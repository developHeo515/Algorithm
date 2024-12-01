import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		bw.write("<");
		while(!list.isEmpty()) {
			for(int i = 1; i <= K; i++) {
				if(i == K) {
					int n = list.remove();
					if(list.isEmpty()) {
						bw.write(n + ">");
					}else {
						bw.write(n + ", ");
					}
				}else {
					list.add(list.remove());
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
