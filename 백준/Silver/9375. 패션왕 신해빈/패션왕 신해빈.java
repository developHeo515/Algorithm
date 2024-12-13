//BOJ9375 패션왕 신해빈, 실버3
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String clothes = st.nextToken();
				String key = st.nextToken();
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			int cnt = 1;
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				cnt = cnt * (entry.getValue()+1);
			}
			System.out.println(cnt-1);
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
