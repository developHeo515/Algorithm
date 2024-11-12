//SWEA14510 나무 높이, D2 
import java.io.*;
import java.util.*;

public class Solution {
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
				one += (max - tree[i]) % 2;
				two += (max - tree[i]) / 2;
			}
			// 짝수 날짜를 적절히 조정하여 균형을 맞추어주어야 최소 날짜가 나오게 됩니다. 
			int temp = Math.max(two - one, 0) / 3;
			one += temp * 2;
			two -= temp;
			int Min = Math.min(two, one);
			
			ans = Min * 2 
					+ Math.max((one - Min) * 2 - 1, 0)
					+(two - Min) / 2 * 3
					+(two - Min) % 2 * 2;
			
			
			bw.write("#" + tc + " " + ans + "\n");
		}
				
		
		bw.flush();
		bw.close();
		br.close();
	}
}
