//BOJ5568 카드 놓기, 실4
import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static String[] str;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		str = new String[N];
		
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		boolean[] visit = new boolean[N];
		dfs(0, "", visit);
		
		bw.write(hs.size() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int depth, String tmp, boolean[] visit) {
		if(depth == K) {
			hs.add(tmp);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(depth + 1, tmp + str[i], visit);			
				visit[i] = false;
			}
		}
		
	}
}
