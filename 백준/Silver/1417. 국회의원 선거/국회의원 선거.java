//BOJ1417 국회의원 선거, 실5
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()) - 1;
		int dasom = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int count = 0;
		while (!pq.isEmpty() && pq.peek() >= dasom) {		
			++dasom;
			pq.add(pq.poll() - 1);
			++count;
		}

		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
