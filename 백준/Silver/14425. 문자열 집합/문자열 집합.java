//BOJ14425 문자열 집합, 실4
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			hm.put(str, 0);
		}
		
		int cnt = 0;
		for(int j = 0; j < M; j++) {
			String str = br.readLine();
			if(hm.containsKey(str)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
