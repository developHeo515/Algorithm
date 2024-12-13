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
				String kind = st.nextToken();
				
//				map.put(kind, map.getOrDefault(kind, 0) + 1);
				if(map.containsKey(kind)) { // 해당 옷이 해시맵에 있을 경우
					map.put(kind, map.get(kind) + 1);
				}else { //해당 옷이 해시맵에 없을 경우
					map.put(kind, 1);
				}
			}
			int cnt = 1;
			for(int val : map.values()) {
				cnt *= (val + 1);
			}
			bw.write(cnt-1 + "\n"); //알몸인 상태를 제외해줘야해서 -1 해줌
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
