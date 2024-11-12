//SWEA14510 나무 높이, D2 
import java.io.*;
import java.util.*;

public class Solution{
	static int ans;
	static int N;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			tree = new int[N];
			int max = 0;
			int one = 0;
			int two = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				tree[i] = num;
			}
			
			for(int i = 0; i < N; i++) {
				int diff = max - tree[i];
				one += diff % 2;
				two += diff / 2;
			}

			if(two - one >= 2) {
				int diff = two - one;
				int move = (diff + 1) / 3;
				one += move * 2;
				two -= move;
			}
			
			ans = two * 2;
			if(one > two) {
				ans += (one - two - 1) * 2 + 1;
			}
			
			bw.write("#" + tc + " " + ans + "\n");
		}
				
		
		bw.flush();
		bw.close();
		br.close();
	}
}
