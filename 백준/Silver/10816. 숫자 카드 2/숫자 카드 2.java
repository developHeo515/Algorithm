//BOJ10816 숫자 카드
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		HashMap<Integer, Integer> hash = new HashMap<>();
			
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(hash.get(input) == null) hash.put(input, 1);
			else hash.put(input, hash.get(input) + 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(hash.get(input) == null) {
				bw.write(0 + " ");				
			}
			else
				bw.write(hash.get(input) + " ");
		}
		

		bw.flush();
		bw.close();
		br.close();
	}
}
